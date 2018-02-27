package com.jftshop.util;

import org.apache.commons.io.FilenameUtils;
import org.im4java.core.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class ImageUtils
{
  private static ImageUtils.Type IIIllIlI = ImageUtils.Type.auto;
  private static String IIIllIll;
  private static String IIIlllII;
  private static final Color IIIlllIl = Color.white;
  private static final int IIIllllI = 88;

  enum Type
  {
    auto, jdk, graphicsMagick, imageMagick;
  }

  static
  {
    String osname;
    String path;
    String[] paths;

    File localFile1;
    File localFile2;

    if (IIIllIlI == ImageUtils.Type.auto)
      try
      {
        IMOperation localObject1 = new IMOperation();
        ((IMOperation)localObject1).version();
        IdentifyCmd localObject2 = new IdentifyCmd(true);
        if (IIIllIll != null)
          ((IdentifyCmd)localObject2).setSearchPath(IIIllIll);
        ((IdentifyCmd)localObject2).run((Operation)localObject1, new Object[0]);
        IIIllIlI = ImageUtils.Type.graphicsMagick;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          IMOperation localObject2 = new IMOperation();
          ((IMOperation)localObject2).version();
          IdentifyCmd localObject3 = new IdentifyCmd(false);
          ((IdentifyCmd)localObject3).run((Operation)localObject2, new Object[0]);
          if (IIIlllII != null)
            ((IdentifyCmd)localObject3).setSearchPath(IIIlllII);
          IIIllIlI = ImageUtils.Type.imageMagick;
        }
        catch (Throwable localThrowable2)
        {
          IIIllIlI = ImageUtils.Type.jdk;
        }
      }
  }

  public static void zoom(File srcFile, File destFile, int destWidth, int destHeight)
  {
    Object localObject1;
    Object localObject2;
    if (IIIllIlI == ImageUtils.Type.jdk)
    {
      localObject1 = null;
      localObject2 = null;
      ImageWriter localImageWriter = null;
      try
      {
        BufferedImage localBufferedImage1 = ImageIO.read(srcFile);
        int i = localBufferedImage1.getWidth();
        int j = localBufferedImage1.getHeight();
        int k = destWidth;
        int m = destHeight;
        if (j >= i)
          k = (int) Math.round(destHeight * 1.0D / j * i);
        else
          m = (int) Math.round(destWidth * 1.0D / i * j);
        BufferedImage localBufferedImage2 = new BufferedImage(destWidth, destHeight, 1);
        localObject1 = localBufferedImage2.createGraphics();
        ((Graphics2D)localObject1).setBackground(IIIlllIl);
        ((Graphics2D)localObject1).clearRect(0, 0, destWidth, destHeight);
        ((Graphics2D)localObject1).drawImage(localBufferedImage1.getScaledInstance(k, m, 4), destWidth / 2 - k / 2, destHeight / 2 - m / 2, null);
        localObject2 = ImageIO.createImageOutputStream(destFile);
        localImageWriter = (ImageWriter) ImageIO.getImageWritersByFormatName(FilenameUtils.getExtension(destFile.getName())).next();
        localImageWriter.setOutput(localObject2);
        ImageWriteParam localImageWriteParam = localImageWriter.getDefaultWriteParam();
        localImageWriteParam.setCompressionMode(2);
        localImageWriteParam.setCompressionQuality(0.88F);
        localImageWriter.write(null, new IIOImage(localBufferedImage2, null, null), localImageWriteParam);
        ((ImageOutputStream)localObject2).flush();
      }
      catch (IOException localIOException8)
      {
        localIOException8.printStackTrace();
        if (localObject1 != null)
          ((Graphics2D)localObject1).dispose();
        if (localImageWriter != null)
          localImageWriter.dispose();
        if (localObject2 == null)
          return;
        try
        {
          ((ImageOutputStream)localObject2).close();
        }
        catch (IOException localIOException1)
        {
        }
      }
      finally
      {
        if (localObject1 != null)
          ((Graphics2D)localObject1).dispose();
        if (localImageWriter != null)
          localImageWriter.dispose();
        if (localObject2 != null)
          try
          {
            ((ImageOutputStream)localObject2).close();
          }
          catch (IOException localIOException2)
          {
          }
      }
      try
      {
        ((ImageOutputStream)localObject2).close();
      }
      catch (IOException localIOException3)
      {
      }
    }
    else
    {
      localObject1 = new IMOperation();
      ((IMOperation)localObject1).thumbnail(Integer.valueOf(destWidth), Integer.valueOf(destHeight));
      ((IMOperation)localObject1).gravity("center");
      ((IMOperation)localObject1).background(IIIllIlI(IIIlllIl));
      ((IMOperation)localObject1).extent(Integer.valueOf(destWidth), Integer.valueOf(destHeight));
      ((IMOperation)localObject1).quality(Double.valueOf(88.0D));
      ((IMOperation)localObject1).addImage(new String[] { srcFile.getPath() });
      ((IMOperation)localObject1).addImage(new String[] { destFile.getPath() });
      if (IIIllIlI == ImageUtils.Type.graphicsMagick)
      {
        localObject2 = new ConvertCmd(true);
        if (IIIllIll != null)
          ((ConvertCmd)localObject2).setSearchPath(IIIllIll);
        try
        {
          ((ConvertCmd)localObject2).run((Operation)localObject1, new Object[0]);
        }
        catch (IOException localIOException6)
        {
          localIOException6.printStackTrace();
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
        }
        catch (IM4JavaException localIM4JavaException2)
        {
          localIM4JavaException2.printStackTrace();
        }
      }
      else
      {
        localObject2 = new ConvertCmd(false);
        if (IIIlllII != null)
          ((ConvertCmd)localObject2).setSearchPath(IIIlllII);
        try
        {
          ((ConvertCmd)localObject2).run((Operation)localObject1, new Object[0]);
        }
        catch (IOException localIOException7)
        {
          localIOException7.printStackTrace();
        }
        catch (InterruptedException localInterruptedException3)
        {
          localInterruptedException3.printStackTrace();
        }
        catch (IM4JavaException localIM4JavaException3)
        {
          localIM4JavaException3.printStackTrace();
        }
      }
    }
  }


  public static void initialize()
  {
  }

  private static String IIIllIlI(Color paramColor)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = Integer.toHexString(paramColor.getRed());
    String str2 = Integer.toHexString(paramColor.getGreen());
    String str3 = Integer.toHexString(paramColor.getBlue());
    str1 = str1.length() == 1 ? "0" + str1 : str1;
    str2 = str2.length() == 1 ? "0" + str2 : str2;
    str3 = str3.length() == 1 ? "0" + str3 : str3;
    localStringBuffer.append("#");
    localStringBuffer.append(str1);
    localStringBuffer.append(str2);
    localStringBuffer.append(str3);
    return localStringBuffer.toString();
  }
}

/* Location:           D:\tomcat7\webapps\shopxx\WEB-INF\classes\
 * Qualified Name:     net.shopxx.util.ImageUtils
 * JD-Core Version:    0.6.2
 */