package org.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Horloge implements Observable {
    //
    Calendar cal;
    private List<Observateur> observateurs;
    private String hour = "";


    public Horloge() {
        observateurs = new ArrayList<>();
        cal = Calendar.getInstance();
    }


    public void run() {
        while (true) {
            cal = Calendar.getInstance();
            this.hour
                    = //Les heures
                    this.cal.get(Calendar.HOUR_OF_DAY) + " : "
                            + ( //Les minutes
                            this.cal.get(Calendar.MINUTE) < 10
                                    ? "0" + this.cal.get(Calendar.MINUTE) : this.cal.get(Calendar.MINUTE)) + ":"
                            + ( //Les secondes
                            (this.cal.get(Calendar.SECOND) < 10) ? "0" + this.cal.get(Calendar.SECOND) : this.cal.get(Calendar.SECOND));
            updateObservateur();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addObservateur(Observateur obs) {
        observateurs.add(obs);
    }

    @Override
    public void updateObservateur() {
        String hour = this.hour;
        for (Observateur obs : observateurs) {
            obs.update(hour);
        }
    }

    @Override
    public void delObservateur() {
        observateurs.clear();
    }


}
