package prominence;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by straz on 24.06.2017.
 */
public class ApplyView extends VerticalLayout implements View {

    public ApplyView() {
        VerticalLayout layout = new VerticalLayout();
       this.setWidth("90%");
       this.setHeight("94%");

        BrowserFrame browser = new BrowserFrame(null,
                new ExternalResource("https://docs.google.com/forms/d/e/1FAIpQLSePSlwfxt3tjfsuEsShJ-D8k4PVGkCpdxOUKLh0DaLsUE8FWg/viewform?embedded=true"));

        browser.setWidth("100%");
        browser.setHeight("100%");
        layout.addComponent(browser);

        layout.setWidth("95%");
        layout.setHeight("100%");

        this.addComponent(layout);
        this.setComponentAlignment(layout, Alignment.TOP_CENTER);
        this.setStyleName("apply-margins");


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
