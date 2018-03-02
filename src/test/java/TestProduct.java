import com.jftshop.entity.*;
import com.jftshop.service.product.CategoryService;
import com.jftshop.service.product.ProductService;
import com.jftshop.service.product.SpecificationService;
import com.jftshop.util.JFTStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ThinkPad on 2018/2/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestProduct {



    @Test
    @Transactional
    public void  test() throws Exception {

        ProductCategory productCategory = categoryService.getOne("70e695e64ae24e83811b6be595ea6fac");

        Specification specification = specificationService.getOne("d5d942adb0534ab48b5b0e559ab0695a");
        List<SpecificationValue> list = specification.getSpecificationValues();

        Specification specification2 = specificationService.getOne("da829783c94d44f396ccb3646d6affba");
        List<SpecificationValue> list2 = specification2.getSpecificationValues();



        Product product = new Product();
        product.setId(JFTStringUtils.get32UUID());
        product.setIntroduction("hello");
        product.setIsgift(true);
        product.setIslist(true);
        product.setIsmarketable(true);
        product.setIstop(true);
        product.setName("hello");
        product.setPrice(new BigDecimal(100));



        ProductSpecification productspecification = new ProductSpecification();
        productspecification.setId(JFTStringUtils.get32UUID());
        productspecification.setName( specification.getName() );
        productspecification.setType(ProductSpecification.Type.text);

        Iterator<SpecificationValue> iterator = list.iterator();
        while ( iterator.hasNext() ){
            SpecificationValue specificationvalue = iterator.next();

            ProductSpecificationValue productspecificationvalue = new ProductSpecificationValue();
            productspecificationvalue.setId(JFTStringUtils.get32UUID());
            productspecificationvalue.setName( specificationvalue.getName() );
            productspecification.getProductspecificationvalues().add( productspecificationvalue );
            productspecificationvalue.setProductspecification( productspecification );
        }

        product.getProductspecifications().add( productspecification );
        productspecification.setProduct( product );

        ProductSpecification productspecification2 = new ProductSpecification();
        productspecification2.setId(JFTStringUtils.get32UUID());
        productspecification2.setName( specification2.getName() );
        productspecification2.setType(ProductSpecification.Type.text);

        Iterator<SpecificationValue> iterator2 = list2.iterator();
        while ( iterator2.hasNext() ){
            SpecificationValue specificationvalue = iterator2.next();

            ProductSpecificationValue productspecificationvalue = new ProductSpecificationValue();
            productspecificationvalue.setId(JFTStringUtils.get32UUID());
            productspecificationvalue.setName( specificationvalue.getName() );
            productspecification2.getProductspecificationvalues().add( productspecificationvalue );
            productspecificationvalue.setProductspecification( productspecification2 );
        }

        product.getProductspecifications().add( productspecification2 );
        productspecification2.setProduct( product );


        int size = product.getProductspecifications().size();

        if (size>0 && size==1){
            List<ProductSpecificationValue> list7 = product.getProductspecifications().get(0).getProductspecificationvalues();
            if ( list7.size() > 0 ){
                for (int i = 0 ; i < list7.size() ; i ++){
                    ProductSpecificationValue productspecificationvalue =  list7.get(i);
                    ProductSku productsku = new ProductSku();
                    productsku.setId(JFTStringUtils.get32UUID());
                    productsku.setProductspecificationvalueid1( productspecificationvalue.getId() );
                    product.getProductskus().add( productsku );
                    productsku.setProduct( product );
                }
            }
        }else{
            List<ProductSpecificationValue> list7 = product.getProductspecifications().get(0).getProductspecificationvalues();
            List<ProductSpecificationValue> list8 = product.getProductspecifications().get(1).getProductspecificationvalues();
            if ( list7.size() > 0 ){
                for ( int i = 0 ; i < list7.size() ; i ++ ){
                    ProductSpecificationValue productspecificationvalue =  list7.get(i);

                    for ( int j = 0 ; j < list8.size() ; j ++ ){
                        ProductSpecificationValue productspecificationvalue2 =  list8.get(j);
                        ProductSku productsku = new ProductSku();
                        productsku.setId(JFTStringUtils.get32UUID());
                        productsku.setProductspecificationvalueid1( productspecificationvalue.getId() );
                        productsku.setProductspecificationvalueid2( productspecificationvalue2.getId() );
                        product.getProductskus().add( productsku );
                        productsku.setProduct( product );
                    }
                }
            }
        }

        product.setProductcategory( productCategory );

        productService.save( product );

    }


    @Autowired
    SpecificationService specificationService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


}
