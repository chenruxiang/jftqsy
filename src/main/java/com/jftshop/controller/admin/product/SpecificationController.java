package com.jftshop.controller.admin.product;

import com.jftshop.controller.BaseController;
import com.jftshop.entity.Specification;
import com.jftshop.entity.SpecificationValue;
import com.jftshop.service.product.SpecificationService;
import com.jftshop.util.JFTStringUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Controller("specificationController")
@RequestMapping({"/admin/product/specification"})
public class SpecificationController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(SpecificationController.class);


    @GetMapping("/listall")
    public String listAll(Model model)
    {
        List<Specification> list = this.specificationService.findAll();
        model.addAttribute("spelist",list);
        return "admin/product/specification/list";
    }

    @PostMapping({"/save"})
    public String submit(Specification specification, @RequestParam("file") MultipartFile[] files,
                         HttpServletRequest request) throws IOException {

        List<SpecificationValue> specificationValues = specification.getSpecificationValues();

        String imagePath = request.getServletContext().getInitParameter("imagePath");
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        File path = new File(imagePath + "/" + date);
        if (!path.exists())
            path.mkdirs();
        for(int i = 0; i < files.length; i++){
            File imageFile = new File(path,JFTStringUtils.get32UUID() + ".jpg");
            files[i].transferTo(imageFile);
            String image = imageFile.getAbsolutePath();
            specificationValues.get(i).setImage(image);
        }

        ListIterator<SpecificationValue> iterator = specificationValues.listIterator();
        while (iterator.hasNext()){
            SpecificationValue specificationValue = iterator.next();
            if (specificationValue == null || JFTStringUtils.isBlank(specificationValue.getName())){
                iterator.remove();
            }
            specificationValue.setId(JFTStringUtils.get32UUID());
            specificationValue.setSpecification(specification);
        }

        specification.setId(JFTStringUtils.get32UUID());
        this.specificationService.save(specification);

        return "admin/product/specification/add";
    }


    @Autowired
    SpecificationService specificationService;

}
