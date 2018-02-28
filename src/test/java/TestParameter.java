import com.jftshop.entity.Parameter;
import com.jftshop.entity.ParameterGroup;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.product.CategoryService;
import com.jftshop.service.product.ParameterService;
import com.jftshop.util.JFTStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Administrator on 2018/2/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestParameter {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ParameterService parameterService;

    @Test
    @Transactional
    public void  test2() throws Exception {

        ProductCategory productCategory = categoryService.getOne("885e0df00af443a795487f52edeaab3ddf");
        ParameterGroup parameterGroup = new ParameterGroup();
        parameterGroup.setId(JFTStringUtils.get32UUID());
        parameterGroup.setProductcategory(productCategory);
        parameterGroup.setOrders(1);
        parameterGroup.setName("参数集2");

        Parameter parameter = new Parameter();
        parameter.setId(JFTStringUtils.get32UUID());
        parameter.setParametergroup(parameterGroup);
        parameter.setName("参数1");
        parameter.setOrders(1);

        parameterGroup.getParameters().add(parameter);

        Parameter parameter2 = new Parameter();
        parameter2.setId(JFTStringUtils.get32UUID());
        parameter2.setParametergroup(parameterGroup);
        parameter2.setName("参数2");
        parameter2.setOrders(2);

        parameterGroup.getParameters().add(parameter2);

     //   List<ParameterGroup> list = this.parameterService.findAll();
     //   System.out.println( "--------------->"+list);
    //    assertNotNull(list);
        parameterService.save(parameterGroup);
        assertNotNull(parameterGroup);

    }

}
