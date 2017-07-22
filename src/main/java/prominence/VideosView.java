package prominence;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Responsive;
import com.vaadin.ui.*;

/**
 * Created by straz on 24.06.2017.
 */
public class VideosView extends VerticalLayout implements View {

    public VideosView() {
        VerticalLayout layout = new VerticalLayout();


        layout.setHeight("93%");
//        layout.setWidth("50%");

//        this.setHeight("100%");
//        this.setWidth("50%");


        String[] videosLinks = {"https://www.youtube.com/embed/Je33NgTlKdE", "https://www.youtube.com/embed/3-kooe_ltMk", "https://www.youtube.com/embed/X52SsJjWkDM"};

        Accordion accordion = new Accordion();
        accordion.setSizeFull();
        for(String vid : videosLinks)
        {
            Panel panel = new Panel();
            BrowserFrame browser = new BrowserFrame(vid,
                    new ExternalResource(vid));

            browser.setWidth("100%");
            browser.setHeight("100%");
            panel.setContent(browser);

            panel.setHeight("100%");
            panel.setWidth("100%");
            accordion.addTab(panel, "Video - " + vid);
            accordion.setStyleName("video-caption-background");
        }


        layout.addComponent(accordion);
        layout.setMargin(false);
        this.addComponent(layout);
        this.setComponentAlignment(layout, Alignment.TOP_CENTER);
        this.setHeight("75%");
        this.setWidth("100%");
        this.setMargin(true);

    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
