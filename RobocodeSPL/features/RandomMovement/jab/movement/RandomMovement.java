package jab.movement;

import robocode.HitWallEvent;
import robocode.Event;
import jab.module.Module;
import jab.module.Movement;
import java.util.Random;

public class RandomMovement extends Movement {
    
    private int moveDirection;
    private Random random;
    
    public RandomMovement(Module bot) {
        super(bot);
        this.random = new Random();
        this.moveDirection = 1; // Mulai dengan arah maju
    }

    public void move() {
        bot.setMaxVelocity(8); // Batasi kecepatan maksimum
        
        // Jarak acak antara 50 hingga 250
        double randomDistance = 50 + (random.nextDouble() * 200);
        
        // Sudut belokan acak antara -90 hingga 90 derajat
        double randomTurn = -90 + (random.nextDouble() * 180);
        
        // Gerakan robot
        bot.setAhead(randomDistance * moveDirection);
        bot.setTurnRight(randomTurn);
    }
    
    public void listen(Event e) {
        if (e instanceof HitWallEvent) {
            moveDirection *= -1; // Berbalik arah jika menabrak dinding
            bot.setTurnRight(random.nextInt(180) - 90); // Putar secara acak
        }
    }
}
