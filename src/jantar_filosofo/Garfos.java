/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantar_filosofo;

public class Garfos {
    private boolean ocupado;

    public Garfos() {
      ocupado = false;
    }

    public synchronized void take() {
      while(ocupado) {
        try {
          wait();
        } catch (InterruptedException e) {}
      }
      ocupado = true;
    }

    public synchronized void drop() {
      ocupado = false;
      notify();
    }
  }