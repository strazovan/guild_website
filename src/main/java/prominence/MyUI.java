package prominence;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.File;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Viewport("width=device-width")
public class MyUI extends UI {


    private VerticalLayout root;
    private Window topBar;
    private VerticalLayout content;
    boolean smallScreen = false;
    final int WIDTH_BORDER = 650;

    Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {


        root = new VerticalLayout();
        root.setHeight("100%");
        root.setWidth("100%");

//        root.setResponsive(true);
        topBar = createTopBar();
//        Panel panel = new Panel();


        content = new VerticalLayout();
        content.setSizeFull();
        content.setWidth("100%");
        content.setHeight("94%");
//        content.setMargin(true);
//        content.addStyleName("content");
        content.setResponsive(true);
        content.addStyleName("v-scrollable");



//        root.setMargin(true);

        navigator = new Navigator(this, content);
        navigator.addView("", new AboutUsView());
        navigator.addView("about", new AboutUsView());
        navigator.addView("apply", new ApplyView());
        navigator.addView("videos", new VideosView());


//        root.setSizeFull();

        addWindow(topBar);
        root.addComponent(content);
        root.setComponentAlignment(content, Alignment.TOP_CENTER);
        root.addStyleName("main-background");

        Responsive.makeResponsive(topBar);

        Responsive.makeResponsive(root);
        Responsive.makeResponsive(content);
        setContent(root);

    }


    private Window createTopBar() {

        Window menu = new Window();
        menu.setPosition(0,0);
        menu.setWidth("100%");
        menu.setHeight("7%");

        menu.setStyleName("menu");
        menu.setResponsive(true);
        menu.setClosable(false);
        menu.setDraggable(false);
        menu.setResizable(false);
//        menu.setStyleName("text-backgroud-box");

        HorizontalLayout menuLayout = new HorizontalLayout();
        menuLayout.setSizeFull();

//        menuLayout.setStyleName("text-backgroud-box");

        ;
        HorizontalLayout logoLayout = new HorizontalLayout();
//        logoLayout.setWidth("5%");
        logoLayout.setWidthUndefined();
        logoLayout.setStyleName("header-window-text");

        HorizontalLayout buttonsLayout = new HorizontalLayout();
//        buttonsLayout.setWidth("30%");
        buttonsLayout.setWidthUndefined();
        buttonsLayout.setStyleName("header-window-text");
        buttonsLayout.setSpacing(false);

//        Label logo = new Label("EMBLEM");

        Image logo = new Image(null, getImage("emblem3.png"));
        logo.setStyleName("logo-image");
        logoLayout.addStyleName("v-margin-left");

        Button aboutUs = new Button("|   About us  |");
        aboutUs.addClickListener(clickEvent -> {
            navigator.navigateTo("about");
        });
        aboutUs.setStyleName(ValoTheme.BUTTON_BORDERLESS);


        Button videos = new Button(" |   Videos    |");
        videos.addClickListener(clickEvent -> {
            navigator.navigateTo("videos");
        });
        videos.setStyleName(ValoTheme.BUTTON_BORDERLESS);

        Button apply = new Button("|   Apply     |");
        apply.addClickListener(clickEvent -> {
            navigator.navigateTo("apply");
        });
        apply.setStyleName(ValoTheme.BUTTON_BORDERLESS);

        MenuBar.Command aboutCmd = new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                navigator.navigateTo("about");
            }
        };
        MenuBar.Command videosCmd = new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                navigator.navigateTo("videos");
            }
        };

        MenuBar.Command applyCmd = new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                navigator.navigateTo("apply");
            }
        };

        MenuBar menubar = new MenuBar();
        menubar.setStyleName("menubar");
        MenuBar.MenuItem main = menubar.addItem("Menu", null, null);
        main.setStyleName("menubar");
        main.addItem("About us", null, aboutCmd);
        main.addItem("Videos", null, videosCmd);
        main.addItem("Apply", null, applyCmd);

        logoLayout.addComponents(logo);

        menuLayout.addComponents(logoLayout);

        changeSize(buttonsLayout, menubar, aboutUs, videos, apply, true);

        menuLayout.addComponent(buttonsLayout);
        menuLayout.setComponentAlignment(buttonsLayout, Alignment.MIDDLE_RIGHT);
        menuLayout.setComponentAlignment(logoLayout, Alignment.MIDDLE_LEFT);


        Page.getCurrent().addBrowserWindowResizeListener((Page.BrowserWindowResizeListener) browserWindowResizeEvent -> {

          changeSize(buttonsLayout, menubar, aboutUs, videos, apply, false);
        });

        menu.setContent(menuLayout);



        return menu;
    }


    private void changeSize(HorizontalLayout buttonsLayout, MenuBar menubar, Button aboutUs, Button videos, Button apply, boolean init )
    {
        int width = UI.getCurrent().getPage().getBrowserWindowWidth();
        if(width < WIDTH_BORDER && (!smallScreen || init )){
            buttonsLayout.removeAllComponents();
            buttonsLayout.addComponent(menubar);
            smallScreen = true;
            Notification.show("Sub 700:" + width);
        }
        if(width >= WIDTH_BORDER && (smallScreen || init ))
        {
            buttonsLayout.removeAllComponents();
            buttonsLayout.addComponent(aboutUs);
            buttonsLayout.addComponent(videos);
            buttonsLayout.addComponent(apply);
            smallScreen = false;
            Notification.show("Above 700:" + width);
        }
    }

    private Resource getImage(String name)
    {


        return  new ThemeResource(name);
}


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}