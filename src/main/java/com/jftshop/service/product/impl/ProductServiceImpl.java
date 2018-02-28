package com.jftshop.service.product.impl;

import com.jftshop.dao.product.ProductRepository;
import com.jftshop.entity.Product;
import com.jftshop.entity.ProductImage;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.ProductService;
import com.jftshop.util.ImageUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.UUID;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product,String>
        implements ProductService   {

    private static final String IIIllIlI = "jpg";
    private static final String IIIllIll = "image/jpeg";
    private static  String picpath = "";

    static {
        String os = System.getProperty("os.name").toLowerCase();
        if ( os.indexOf("windows") !=-1 ) picpath = "d:/upload";
        if ( os.indexOf("linux") !=-1 ) picpath = "/upload";
    }

    private ServletContext servletContext;

    @Resource(name="taskExecutor")
    private TaskExecutor taskExecutor;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    public void setBaseDao(ProductRepository productRepository)
    {
        super.setBaseDao(productRepository);
    }


    public void build(ProductImage productImage){

        MultipartFile localMultipartFile = productImage.getFile();

        if ((localMultipartFile != null) && (!localMultipartFile.isEmpty()))

            try
            {

                String str2 = UUID.randomUUID().toString();

                String source = picpath + "/" + str2 + "/source." + FilenameUtils.getExtension(localMultipartFile.getOriginalFilename());
                String large = picpath + "/" + str2 + "/large." + "jpg";
                String medium = picpath + "/" + str2 + "/medium." + "jpg";
                String thumbnail = picpath + "/" + str2 + "/thumbnail." + "jpg";

                File localFile = new File(source);

                if (!localFile.getParentFile().exists())
                    localFile.getParentFile().mkdirs();
                localMultipartFile.transferTo(localFile);

                IIIllIlI( localFile , large, medium, thumbnail  );

                productImage.setSource( source );
                productImage.setLarge( large );
                productImage.setMedium( medium );
                productImage.setThumbnail( thumbnail );

            }
            catch (Exception localException1)
            {
                localException1.printStackTrace();
            }
    }


    private void IIIllIlI( File srcFile , String large, String medium, String thumbnail )
    {
        try
        {
            this.taskExecutor.execute( new aaa(  srcFile, large, medium, thumbnail ) );
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }


    public class aaa
            implements Runnable
    {

        File srcFile = null;
        String paramString1 = null;
        String paramString2 = null;
        String paramString3 = null;

        aaa( File srcFile, String paramString1, String paramString2, String paramString3)
        {
            this.srcFile = srcFile;
            this.paramString1 = paramString1;
            this.paramString2 = paramString2;
            this.paramString3 = paramString3;
        }

        public void run(){
            ImageUtils.zoom( srcFile, new File(paramString1) , 800, 800 );
            ImageUtils.zoom( srcFile, new File(paramString2), 300, 300 );
            ImageUtils.zoom( srcFile, new File(paramString3), 170, 170);
        }
    }
}
