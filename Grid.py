import pygame  
import os



pygame.init()  
width, height = 1200, 600 
screen = pygame.display.set_mode((width,height))  
pygame.display.set_caption("Visualizer")
done = False  
white = (255,255,255)
      
while not done:  
    for event in pygame.event.get():  
        if event.type == pygame.QUIT:  
            done = True  
    WIN.fill(white)
    pygame.display.flip()  