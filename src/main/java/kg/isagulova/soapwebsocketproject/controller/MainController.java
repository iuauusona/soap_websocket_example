package kg.isagulova.soapwebsocketproject.controller;

import kg.isagulova.soapwebsocketproject.domain.Item;
import kg.isagulova.soapwebsocketproject.service.ItemService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    private ItemService itemService;

    public MainController(ItemService itemService) {
        this.itemService = itemService;
    }

    // во все запросы будет добавляться items
    @ModelAttribute("items")
    public List<Item> addAttributeItems() {
        return itemService.getAll();
    }

    @RequestMapping({"/", "/*", "/index.html"})
    public String getIndex() {
        return "index";
    }

    // ловит сообщения по топику item
    // то, что будет внутри body преобразует в Item
    @MessageMapping("/item")
    // будет послано на топик items
    // работает только в контроллере. в сервисах, репозиториях не работает
    @SendTo("/topic/items")
    public Item addItem(Item item) {
        itemService.addItem(item);
        return item;
    }
}