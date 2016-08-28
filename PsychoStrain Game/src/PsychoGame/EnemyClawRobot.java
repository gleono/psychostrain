/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PsychoGame;

import PsychoSystem.Physics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class EnemyClawRobot extends Enemy {
    private int local1;
    
    public EnemyClawRobot(int Xposition, int Yposition, int damagePerHit, int hp, int timeInactive, int timeLoop){
        super("EnemyClawRobot.txt", "enemy/ClawRobot", Xposition, Yposition, damagePerHit, hp, timeInactive, timeLoop);
        setDirection(direction.BACKWARD);
        local1 = 0;
    }
    
     @Override
    public Rectangle getBounds(){
        return new Rectangle((int)getScreenXPosition(), (int)getYposition()+2, 70, 60);
    }
   
   private void jump(){
       if(this.getState()!=EnemyState.JUMPING){
                 setState(EnemyState.JUMPING);
             }
        if(isJumping()){
            setVY(-13);
        }
    }
   
    public void enemyIntelligence(){
       
        if(TimeToHit1){
            this.moveXposition(this.getVX());
            if(getVX() == 0){
                jump();
            }
        if(this.getScreenXPosition() > Engine.hacker.getXposition()){
            
            this.setVX(-6.0); 
            
            if(this.getDirection()!= direction.BACKWARD){
                 setDirection(direction.BACKWARD);
                
             }
            if(isJumping()){
            if(this.getState()!=EnemyState.WALKING){
                 setState(EnemyState.WALKING);
             }
            }    
        } 
            
            if(this.getScreenXPosition() < Engine.hacker.getXposition()) {
                this.setVX(6.0);
              
            if(this.getDirection()!= direction.FORWARD){
                 setDirection(direction.FORWARD);
                
             }
                
             if(isJumping()){
             if(this.getState()!=EnemyState.WALKING){
                 setState(EnemyState.WALKING);
             }
             }
            
            }
           
    }else{
             if(this.getState()!=EnemyState.ATTACKING){
                 setState(EnemyState.ATTACKING);
             }
        }
    }
     @Override
    public BufferedImage getEnemySecuence(){
        Physics.gravity(this);
        setStateEnemy();
        
        if(this.getState()==EnemyState.WAITING){
            local1=0;
        }
        
        if(getDirection()==direction.FORWARD){
            if(this.getState()==EnemyState.WALKING){
                if(local1<1||local1>15){
                    local1=1;
                }
                local1++;
        }
        
        if(this.getState()==EnemyState.ATTACKING){
                if(local1<17||local1>32){
                    local1=17;
                }
                local1++;
        }
         if(this.getState()==EnemyState.JUMPING){
                if(local1<75||local1>82){
                    local1=75;
                }
                local1++;
        }
            
     }
        
        
        if(getDirection()==direction.BACKWARD){
            if(this.getState()==EnemyState.WALKING){
                if(local1<34||local1>48){
                    local1=34;
                }
                local1++;
        }
        
        if(this.getState()==EnemyState.ATTACKING){
                if(local1<50||local1>65){
                    local1=50;
                }
                local1++;
        }
         if(this.getState()==EnemyState.JUMPING){
                if(local1<67||local1>74){
                    local1=67;
                }
                local1++;
        }
            
     }
        return ObjectSecuence[local1];
    }
    
      @Override
    public String toString(){
          String s= ">2";
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