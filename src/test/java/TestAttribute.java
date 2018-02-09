import com.jftshop.dao.product.AttributeRepository;
import com.jftshop.dao.product.CategoryRepository;
import com.jftshop.entity.Attribute;
import com.jftshop.entity.AttributeOption;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.product.AttributeService;
import com.jftshop.util.JFTStringUtils;
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


    @Test
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
        attribute.getAttributeoptions().add( attributeOption1 );

        attribute.setProductcategory( productCategory );

        attributeRepository.save( attribute );


    }
}
