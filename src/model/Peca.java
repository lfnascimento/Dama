/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import JPlay.Sprite;
import java.awt.Point;

/**
 *
 * @author VíviannMagaly
 */
public class Peca {

    private Sprite spritePeca = new Sprite("peca_vermelha.png", 2);
    private boolean sentidoSubindo;
    private boolean dama;

    public Peca(double eixoXini, double eixoYini, boolean sentidoSubindo, boolean dama) {
        this.spritePeca.setPosition(eixoXini, eixoYini);
        this.sentidoSubindo = sentidoSubindo;
        this.dama = dama;
        this.spritePeca.setCurrFrame(0);
    }

    public void draw() {
        this.spritePeca.draw();
    }

    public void andar(Point p) {
        if (!dama) {
            if (!sentidoSubindo) {
                this.spritePeca.y = this.spritePeca.y + 80;
                if (p.x < spritePeca.x) {
                    this.spritePeca.x = this.spritePeca.x - 80;
                } else {
                    this.spritePeca.x = this.spritePeca.x + 80;
                }
                if(this.spritePeca.y == 568) { //Casa que ele vira dama
                    viraDama();
                }
            } else {
                this.spritePeca.y = this.spritePeca.y - 80;
                if (p.x < spritePeca.x) {
                    this.spritePeca.x = this.spritePeca.x - 80;
                } else {
                    this.spritePeca.x = this.spritePeca.x + 80;
                }
            }
        }
    }
    
    private void viraDama() {
        this.dama = true;
        this.spritePeca.setCurrFrame(1);        
    }

    public JPlay.Point getPosition() {
        return this.spritePeca.getPosition();

    }

    public int getWidth() {
        return this.spritePeca.width;
    }

    public int getHeight() {
        return this.spritePeca.height;
    }

    public Sprite getSpritePeca() {
        return spritePeca;
    }

    public void setSpritePeca(Sprite spritePeca) {
        this.spritePeca = spritePeca;
    }

    public boolean getSentidoSubindo() {
        return sentidoSubindo;
    }

    public void setSentidoSubindo(boolean sentido) {
        this.sentidoSubindo = sentido;
    }

    public boolean isDama() {
        return dama;
    }

    public void setDama(boolean dama) {
        this.dama = dama;
    }

}