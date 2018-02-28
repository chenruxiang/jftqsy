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
        specification.setName( "尺寸");
        specification.setType(Specification.Type.image);
        specification.setMemo("男装");
        specification.setOrders(3);

        SpecificationValue specificationValue = new SpecificationValue();
        specificationValue.setId( JFTStringUtils.get32UUID() );
        specificationValue.setName( "均码" );
        specificationValue.setImage("www.baidu.com");
        specificationValue.setSpecification( specification );

        SpecificationValue specificationValue2 = new SpecificationValue();
        specificationValue2.setId( JFTStringUtils.get32UUID() );
        specificationValue2.setName( "XL" );
        specificationValue2.setImage("www.qq.com");
        specificationValue2.setSpecification( specification );

        specification.getSpecificationValues().add( specificationValue );
        specification.getSpecificationValues().add( specificationValue2 );

        specificationService.save( specification );

    }

}
