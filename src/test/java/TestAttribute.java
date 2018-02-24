import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jftshop.dao.product.AttributeRepository;
import com.jftshop.dao.product.CategoryRepository;
import com.jftshop.entity.Attribute;
import com.jftshop.service.product.AttributeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

//import com.jftshop.dao.ProductCategoryRepository;

/**
 * Created by ThinkPad on 2018/2/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestAttribute {

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    CategoryRepository categoryrepository;

    @Autowired
    AttributeService attributeService;


/*    @Test
    @Transactional
    public void  test2() throws Exception {

        Attribute attribute = attributeService.getOne( "6576760c89e9486482af46c119b01a19");

        assertNotNull(attribute);

    }*/

/*    @Test
    @Transactional
    public void  test() throws Exception {
        ProductCategory productCategory = categoryrepository.getOne( "70e695e64ae24e83811b6be595ea6fac" );
        Attribute attribute = new Attribute();
        attribute.setId( JFTStringUtils.get32UUID() );
        attribute.setName("ABC");
        attribute.setOrders(11);
        attribute.setPropertyindex(11);
        AttributeOption attributeOption1 = new AttributeOption();
        attributeOption1.setId( JFTStringUtils.get32UUID() );
        attributeOption1.setOptions("A1");
        //!!!!
        attributeOption1.setAttribute( attribute );
        attribute.getAttributeoptions().add( attributeOption1 );
        attribute.setProductcategory( productCategory );
        attributeRepository.save( attribute );
    }*/


    @Test
    @Transactional
    public void  test() throws Exception {

        Attribute attribute = attributeRepository.getById( "462b345a9dbe4517a52fe68f9b0792a8");

        System.out.println( "------------------>" + attribute.getId());

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().enableComplexMapKeySerialization().create();
        Gson gson2 = new GsonBuilder().create();


        Attribute attribute2 = new Attribute();attribute2.setId("123");
        System.out.println( "------------------>" + gson.toJson( attribute  ));
        System.out.println( "------------------>" + gson.toJson( attribute2  ));

    }
}
