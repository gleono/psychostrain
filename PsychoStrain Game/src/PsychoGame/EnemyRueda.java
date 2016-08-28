package PsychoGame;

import PsychoSystem.Physics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class EnemyRueda extends Enemy {
    
    private int local1;
    
    public EnemyRueda(int Xposition, int Yposition, int damagePerHit, int hp, int timeInactive, int timeLoop){
        super("EnemyRueda.txt", "enemy/Rueda", Xposition, Yposition, damagePerHit, hp, timeInactive, timeLoop);
        setDirection(direction.BACKWARD);
        local1 = 0;
    }
    
     @Override
    public Rectangle getBounds(){
        return new Rectangle((int)getScreenXPosition(), (int)getYposition()+2, 37, 38);
    }
     
     @Override
    public void enemyIntelligence(){
        if(this.getScreenXPosition() > Engine.hacker.getXposition()){
            this.setVX(-6.0); 
            this.moveXposition(this.getVX());
            
            if(this.getDirection()!= direction.BACKWARD){
                 setDirection(direction.BACKWARD);
            }
        }

        if(this.getScreenXPosition() < Engine.hacker.getXposition()) {
            this.setVX(6.0);
            this.moveXposition(this.getVX());
              
            if(this.getDirection()!= direction.FORWARD){
                 setDirection(direction.FORWARD);    
            }
        }
    }
           
    @Override
    public BufferedImage getEnemySecuence(){
        Physics.gravity(this);
        setStateEnemy();
        
        if(getDirection()==direction.FORWARD){    
            if(local1<0||local1>1){
                local1=0;
            }
            local1++;
        }

        if(getDirection()==direction.BACKWARD){
            if(local1<0||local1>1){
                local1=0;
            }
            local1++;
        }
        return ObjectSecuence[local1];
    }

    @Override
    public String toString(){
          String s= ">4";
          if(this.getYposition()<10){
              s+="00";

          }else if(this.getYposition()>=10 && this.getYposition()<100){
              s+="0";
          }
          s+=(int)this.getYposition();
          s+=(int)this.getXposition();
          return s;
    }
}