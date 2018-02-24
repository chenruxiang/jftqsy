import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jftshop.dao.product.CategoryRepository;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.product.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestproductCategory {


    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

//    @Test
//    @Transactional
//    public void  test() throws Exception {
//
//        ProductCategory pc = new ProductCategory();
//        pc.setId( JFTStringUtils.get32UUID() );
//        pc.setName("女装");
//
//        ProductCategory pc2 = new ProductCategory();
//        pc2.setId( JFTStringUtils.get32UUID() );
//        pc2.setName("女装");
//
//        pc2.setParent( pc );
//
//        categoryRepository.save( pc );
//
//        categoryRepository.save( pc2 );
//
//
//        List<ProductCategory> list = categoryRepository.findByName( "女装" );
//
//        System.out.println("---------------------->" + list.size() );
//
//    }


    @Test
    @Transactional
    public void  test2() throws Exception {

        ProductCategory pc = categoryRepository.getById("70e695e64ae24e83811b6be595ea6fac");

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().enableComplexMapKeySerialization().create();

        System.out.println( "------------------>" + gson.toJson( pc  ) );

    }

}
