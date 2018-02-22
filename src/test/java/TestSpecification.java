import com.jftshop.entity.Specification;
import com.jftshop.entity.SpecificationValue;
import com.jftshop.service.product.SpecificationService;
import com.jftshop.util.JFTStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestSpecification {

    @Autowired
    SpecificationService specificationService;

    @Test
    @Transactional
    public void  test() throws Exception {

        Specification specification = new Specification();
        specification.setId( JFTStringUtils.get32UUID() );
        specification.setName( "SpecificationName");
        specification.setType(Specification.Type.text);
        specification.setMemo("setMemo");
        specification.setOrders(11);

        SpecificationValue specificationValue = new SpecificationValue();
        specificationValue.setId( JFTStringUtils.get32UUID() );
        specificationValue.setName( "specificationValue" );
        specificationValue.setSpecification( specification );

        specification.getSpecificationValues().add( specificationValue );

        specificationService.save( specification );

    }

}
