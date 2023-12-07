package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CollisionUtils {
    public static boolean isCollisionPlayerAndObstacles(Player player, Obstacle obstacle) {
        // Encontrando o ponto do Player do Obstáculo
        float closestX = Math.min(obstacle.getX(), player.getPersonX() + player.getWidth());
        float closestY = Math.min(obstacle.getY(), player.getPersonY() + player.getHeight());

        // Encontrando o ponto máximo entre o Player e o Obstáculo
        float farthestX = Math.max(obstacle.getX(), player.getPersonX());
        float farthestY = Math.max(obstacle.getY(), player.getPersonY());

        // calculando a distância do ponto mais próximo do circulo
        float distanceX = obstacle.getX() - closestX;
        float distanceY = obstacle.getY() - closestY;
        float distancePlayer = distanceX * distanceX + distanceY * distanceY;

        // Verifica a distância do Player para o Radio do Obstaculo
        return distancePlayer <= (obstacle.getRadius() * obstacle.getRadius())
                && farthestX <= (obstacle.getX() + obstacle.getRadius())
                && farthestY <= (obstacle.getY() + obstacle.getRadius());
    }
}
