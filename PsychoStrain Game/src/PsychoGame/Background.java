
//Background.java

package PsychoGame;

import java.awt.*;
import java.awt.image.BufferedImage;

//  PsySoft Team 2008
//       (Manuel Espinoza, Alberto Zorrilla, Guillermo Leon y Arquimides Diaz)

public class Background {
    
    private BufferedImage[] images;
    private String assetName;
    private int[] imageOffsets;
    private int numImages,viewPortX,viewPortY,width,height,direc;

   public Background(String assetName, BufferedImage[] images, 
        int direc, int viewPortX, int viewPortY, int viewPortWidth, int viewPortHeight) {
            
      this.assetName= assetName;
      if (viewPortWidth <= 0 || viewPortHeight <= 0) {
        throw new IllegalArgumentException("ImageAssetRibbon.constructor: " +
                   "Invalid viewport size.");
      }
      this.images = images;
      this.numImages = images.length;
      this.direc=direc;
      this.viewPortX = viewPortX;
      this.viewPortY = viewPortY;
      this.width = viewPortWidth;
      this.height = viewPortHeight;
      imageOffsets = new int[this.numImages + 1];
      int totalOffset = 0;
      for (int idx = 0; idx < this.numImages; idx++) {
         imageOffsets[idx] = totalOffset;
         totalOffset +=(direc==1) ? images[idx].getHeight() : images[idx].getWidth();
      }
      imageOffsets[numImages] = totalOffset;
   }

   public int getViewPortX() {
        return viewPortX;
   }

   public int getViewPortY() {
        return viewPortY;
   }

   public void setViewPort(int viewPortX, int viewPortY) {
        this.viewPortX = viewPortX;
        this.viewPortY = viewPortY;
   }

   public void moveViewPort(int viewPortMoveX, int viewPortMoveY) {
       viewPortX += viewPortMoveX;
       viewPortY += viewPortMoveY;
   }

   public void moveViewPortUp(int magnitude) {
        viewPortY -= magnitude;
   }

   public void moveViewPortDown(int magnitude) {
        viewPortY += magnitude;
   }

   public void moveViewPortLeft(int magnitude) {
        viewPortX -= magnitude;
    }

   public void moveViewPortRight(int magnitude) {
        viewPortX += magnitude;
   }

   private void validateViewPort() {
        if (direc==0) {
            viewPortX = viewPortX % imageOffsets[numImages];
            if( viewPortX < 0 )
                viewPortX = imageOffsets[numImages] + viewPortX;
        } else {
            viewPortY = viewPortY % imageOffsets[numImages];
            if( viewPortY < 0 )
                viewPortY = imageOffsets[numImages] + viewPortY;
        }        
   }

   public BufferedImage getImageRealisation() {
       GraphicsConfiguration graphicsConfiguration =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

       BufferedImage realisedImage = graphicsConfiguration.createCompatibleImage(
                width, height, images[0].getColorModel().getTransparency());

       Graphics2D graphics2D = realisedImage.createGraphics();
       this.draw(graphics2D, 0, 0);
       graphics2D.dispose();

       return realisedImage;
    }

    public void draw(Graphics2D graphics2D, int drawX, int drawY) {
        if (direc==1) {
            drawVertical(graphics2D, drawX, drawY);
        } else {
            drawHorizontal(graphics2D, drawX, drawY);
        }
    }

    public void drawHorizontal(Graphics2D graphics2D, int drawX, int drawY) {
        // Validate the viewport to ensure it is within the bounds of the strip
        validateViewPort();

        int drawWidth;
        int drawOffset = 0;
        int viewPortOffset = viewPortX;
        int currentImageIdx = 0;

        // Determine the image on which the viewport starts
        while (imageOffsets[currentImageIdx + 1] < viewPortX) {
            currentImageIdx++;
        }
        
        // Repeately draw images until the entire viewport has been rendered
        while (drawOffset < width) {
            // Determine how much of the current image should be drawn 
            drawWidth = imageOffsets[currentImageIdx + 1] - viewPortOffset;
            if (drawOffset + drawWidth > width)
                drawWidth = width - drawOffset;

            // Draw the current image at the correct offset 
            graphics2D.drawImage(images[currentImageIdx], drawX + drawOffset, 
                    drawY, drawX + drawOffset + drawWidth, drawY + height, 
                    viewPortOffset - imageOffsets[currentImageIdx], viewPortY, 
                    viewPortOffset - imageOffsets[currentImageIdx] + drawWidth, 
                    viewPortY + height, null);

            // Wrap around the first image if we run off the end of the image strip
            drawOffset += drawWidth;
            viewPortOffset = (viewPortOffset + drawWidth) % imageOffsets[numImages];
            currentImageIdx = (currentImageIdx + 1) % numImages;
        }
    }

   public void drawVertical(Graphics2D graphics2D, int drawX, int drawY) {
        // Validate the viewport to ensure it is within the bounds of the strip
        validateViewPort();

        int drawHeight;
        int drawOffset = 0;
        int viewPortOffset = viewPortY;
        int currentImageIdx = 0;

        // Determine the image on which the viewport starts
        while (imageOffsets[currentImageIdx + 1] < viewPortY) {
            currentImageIdx++;
        }
        
        // Repeately draw images until the entire viewport has been rendered
        while (drawOffset < height) {
            drawHeight = imageOffsets[currentImageIdx + 1] - viewPortOffset;
            if (drawOffset + drawHeight > height)
                drawHeight = height - drawOffset;

            // Draw the current image at the correct offset within the graphics object
            graphics2D.drawImage(images[currentImageIdx], drawX, drawY + drawOffset, 
                    drawX + width, drawY + drawOffset + drawHeight, viewPortX, 
                    viewPortOffset - imageOffsets[currentImageIdx], viewPortX + width, 
                    viewPortOffset - imageOffsets[currentImageIdx] + drawHeight, null);

            // Wrap around the first image if we run off the end of the image strip
            drawOffset += drawHeight;
            viewPortOffset = (viewPortOffset + drawHeight) % imageOffsets[numImages];
            currentImageIdx = (currentImageIdx + 1) % numImages;
        }
    }
}