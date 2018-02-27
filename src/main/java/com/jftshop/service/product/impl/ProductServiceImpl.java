package com.jftshop.service.product.impl;

import com.jftshop.dao.product.ProductRepository;
import com.jftshop.entity.Product;
import com.jftshop.entity.ProductImage;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.ProductService;
import com.jftshop.util.ImageUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.UUID;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product,String>
        implements ProductService {

    private static final String IIIllIlI = "jpg";
    private static final String IIIllIll = "image/jpeg";

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

                String str1 = "/upload";
                String str2 = UUID.randomUUID().toString();

                String str3 = str1 + str2 + "-source." + FilenameUtils.getExtension(localMultipartFile.getOriginalFilename());
                String str4 = str1 + str2 + "-large." + "jpg";
                String str5 = str1 + str2 + "-medium." + "jpg";
                String str6 = str1 + str2 + "-thumbnail." + "jpg";

                File localFile = new File(System.getProperty("java.io.tmpdir") + "/upload_" + UUID.randomUUID() + ".tmp");

                if (!localFile.getParentFile().exists())
                    localFile.getParentFile().mkdirs();

                localMultipartFile.transferTo(localFile);

                IIIllIlI(str3, str4, str5, str6, localFile, localMultipartFile.getContentType());

                productImage.setSource( str3 );
                productImage.setLarge( str4 );
                productImage.setMedium( str5 );
                productImage.setThumbnail( str6 );

            }
            catch (Exception localException1)
            {
                localException1.printStackTrace();
            }
    }


    private void IIIllIlI(String paramString1, String paramString2, String paramString3, String paramString4, File paramFile, String paramString5)
    {
        try
        {
            this.taskExecutor.execute( new aaa( this, paramFile, paramString1, paramString5, paramString2, paramString3, paramString4 ) );
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }


    public class aaa
            implements Runnable
    {

        File paramFile = null;

        aaa(ProductServiceImpl productServiceImpl, File paramFile, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
        {

            this.paramFile = paramFile;
        }

        public void run()
        {

                    String str = System.getProperty("java.io.tmpdir");

                    File localFile2 = new File(str + "/upload_" + UUID.randomUUID() + "." + "jpg");
                    File localFile3 = new File(str + "/upload_" + UUID.randomUUID() + "." + "jpg");
                    File localFile4 = new File(str + "/upload_" + UUID.randomUUID() + "." + "jpg");

                    try
                    {
                        ImageUtils.zoom( paramFile, localFile2, 800, 800 );

                        ImageUtils.zoom( paramFile, localFile3, 300, 300 );

                        ImageUtils.zoom( paramFile, localFile4, 170, 170);

                   /*     upload(this.IIIlllII, this.IIIllIll, this.IIIlllIl);
                        upload(this.IIIllllI, localFile2, "image/jpeg");
                        upload(this.IIIlllll, localFile3, "image/jpeg");
                        upload(this.IIlIIIII, localFile4, "image/jpeg");*/

                    }

                    finally
                    {
                        FileUtils.deleteQuietly(paramFile);
                        FileUtils.deleteQuietly(localFile2);
                        FileUtils.deleteQuietly(localFile3);
                        FileUtils.deleteQuietly(localFile4);
                    }
        }

        public void upload(String path, File file, String contentType)
        {
         /*   File localFile = new File(this.IIIllIlI.getRealPath(path));
            try
            {
                FileUtils.moveFile(file, localFile);
            }
            catch (IOException localIOException)
            {
                localIOException.printStackTrace();
            }*/
        }
    }


}
