package PsychoGame;

import PsychoSystem.Physics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//  PsySoft Team 2008
//       (Manuel Espinoza, Alberto Zorrilla, Guillermo Leon y Arquimides Diaz)

public class EnemyRobot extends Enemy{

    private int local1;
    
  public EnemyRobot(int Xposition, int Yposition, int damagePerHit, int hp, int timeInactive, int timeLoop){
        super("EnemyRobot.txt", "enemy/Robot", Xposition, Yposition, damagePerHit, hp, timeInactive, timeLoop);
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
    @Override
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
                if(local1<1||local1>9){
                    local1=1;
                }
                local1++;
        }
        
        if(this.getState()==EnemyState.ATTACKING){
                if(local1<10||local1>16){
                    local1=10;
                }
                local1++;
        }
         if(this.getState()==EnemyState.JUMPING){
                if(local1<43||local1>49){
                    local1=43;
                }
                local1++;
        }
            
     }
        
        
        if(getDirection()==direction.BACKWARD){
            if(this.getState()==EnemyState.WALKING){
                if(local1<18||local1>26){
                    local1=18;
                }
                local1++;
        }
        
        if(this.getState()==EnemyState.ATTACKING){
                if(local1<27||local1>34){
                    local1=27;
                }
                local1++;
        }
         if(this.getState()==EnemyState.JUMPING){
                if(local1<35||local1>41){
                    local1=35;
                }
                local1++;
        }
            
     }
      return ObjectSecuence[local1];
    }
    
    @Override
    public String toString(){
        String s= ">0";
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