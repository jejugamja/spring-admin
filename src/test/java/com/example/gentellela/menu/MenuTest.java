package com.example.gentellela.menu;


import com.example.gentellela.menu.domain.Menu;
import com.example.gentellela.menu.domain.repository.MenuRepository;
import com.example.gentellela.menu.service.MenuService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MenuTest {
    @Autowired
    private MenuRepository menuRepository;

    @Before
    public void setup() {
        Menu menu = new Menu("menu1", "icon1", "link1");
        Menu child = new Menu("child1", "child-icon1", "child-link1");
        menu.addMenu(child);
        menuRepository.save(menu);
    }

    @Test
    public void test() {
        menuRepository.findById(1L)
                .ifPresent(t -> {
                    System.out.println(t.getIcon());
                    System.out.println(t.getId());
                    System.out.println(t.getName());
                    System.out.println(t.getChildMenus().size());
                    Menu child = t.getChildMenus().get(0);
                    System.out.println(child.getName());
                });
    }
}
