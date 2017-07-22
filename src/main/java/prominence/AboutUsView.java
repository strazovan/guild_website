package prominence;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Responsive;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by straz on 24.06.2017.
 */
public class AboutUsView extends VerticalLayout implements View {

    public AboutUsView() {

        Label header = new Label("<h1><font color=\"white\">About us</h1>", ContentMode.HTML);

        String text = "<font color=\"white\"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ait enim se, si uratur, Quam hoc suave! dicturum. Tum Triarius:" +
                " Posthac quidem, inquit, audacius. Tenent mordicus. Quod non faceret, si in voluptate summum bonum poneret. </br>Duo Reges: constructio interrete. " +
                "Scientiam pollicentur, quam non erat mirum sapientiae cupido patria esse cariorem. Praeterea sublata cognitione et scientia tollitur omnis ratio et vitae degendae " +
                "et rerum gerendarum. </br>Sed quanta sit alias, nunc tantum possitne esse tanta. Aliter enim explicari, quod quaeritur, non potest. Quid, quod homines infima fortuna, " +
                "nulla spe rerum gerendarum, opifices denique delectantur historia? </p>\n" +
                "\n" +
                "<p>Scio enim esse quosdam, qui quavis lingua philosophari possint; Nulla profecto est, quin suam vim retineat a primo ad extremum. Quodsi ipsam honestatem undique" +
                " pertectam atque absolutam. Obsecro, inquit, Torquate, haec dicit Epicurus? </br>Nam Pyrrho, Aristo, Erillus iam diu abiecti. Portenta haec esse dicit, neque ea ratione" +
                " ullo modo posse vivi; At iam decimum annum in spelunca iacet. </p>\n"

               ;
        Label abousUs = new Label(text, ContentMode.HTML);

//        header.setHeight("10%");
//        abousUs.setHeight("100%");
        abousUs.setWidth("100%");
        this.addComponent(header);
        this.setComponentAlignment(header, Alignment.TOP_CENTER);
        this.addComponent(abousUs);
//        this.setWidth("100%");
//        this.setHeight("100%");
        this.addStyleName("text-backgroud-box");

//        Responsive.makeResponsive(this);


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
