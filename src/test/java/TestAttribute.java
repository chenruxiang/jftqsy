import com.jftshop.dao.AttributeRepository;
//import com.jftshop.dao.ProductCategoryRepository;
import com.jftshop.entity.Attribute;
import com.jftshop.entity.AttributeOption;
import com.jftshop.util.JFTStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ThinkPad on 2018/2/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestAttribute {

    @Autowired
    AttributeRepository attributeRepository;


    @Test
    @Transactional
    public void  test() throws Exception {

        Attribute attribute = new Attribute();
        attribute.setId( JFTStringUtils.get32UUID() );
        attribute.setName("ABC");
        attribute.setOrders(11);
        attribute.setPropertyindex(11);

        AttributeOption attributeOption1 = new AttributeOption();
        attributeOption1.setId( JFTStringUtils.get32UUID() );
        attributeOption1.setOptions("A1");
        //attributeOption1.setAttribute( attribute );



/*        AttributeOption attributeOption2 = new AttributeOption();
        attributeOption2.setId( JFTStringUtils.get32UUID() );
        attributeOption2.setOptions("A2");
        attributeOption2.setAttribute( attribute );

        attribute.addAttributeOption( attributeOption1 );
        attribute.addAttributeOption( attributeOption2 );*/

        //ProductCategory productCategory = productCategoryRepository.getOne( "70e695e64ae24e83811b6be595ea6fac" );

        //productCategory.getAttributes().add( attribute );

        attributeRepository.save( attribute );


        //System.out.println("------------------->"+ productCategory.getName());

        System.out.println("------------------->"+ attributeRepository.findAll().size());

    }
}
