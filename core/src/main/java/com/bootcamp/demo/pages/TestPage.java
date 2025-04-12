package com.bootcamp.demo.pages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.bootcamp.demo.engine.Resources;
import com.bootcamp.demo.pages.core.APage;
import lombok.Getter;

public class TestPage extends APage {
    public static String SQUIRCLE = "basics/white-squircle-35";

    @Override
    protected void constructContent(Table content) {
        MainContainer mainContainer = new MainContainer();
        content.setFillParent(true);
        content.add(mainContainer).growX().expandY().bottom();
    }

    public final class MainContainer extends Table {
        StatsContainer statsContainer;
        GearContainer gearContainer;
        OtherContainer otherContainer;

        public MainContainer() {
            defaults().pad(30);
            setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#FFFBDB")));

            final Table segmentContainerOne = constructStatsSegment();
            final Table segmentContainerTwo = constructGearSegment();
            final Table segmentContainerThree = constructOtherSegment();

            add(segmentContainerOne).expandX().fillX().pad(20).height(300);
            row();
            add(segmentContainerTwo).expand().fill().pad(20).height(400);
            row();
            add(segmentContainerThree).expandX().fillX().pad(20).height(150);

            this.pack();
        }

        private Table constructStatsSegment() {
            statsContainer = new StatsContainer();
            Table table = new Table();
            table.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#30362F")));
            table.add(statsContainer).expand().fill();
            return table;
        }

        private Table constructGearSegment() {
            gearContainer = new GearContainer();
            Table table = new Table();
            table.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#30362F")));
            table.add(gearContainer).expand().fill();
            return table;
        }

        private Table constructOtherSegment() {
            otherContainer = new OtherContainer();
            Table table = new Table();
            table.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#30362F")));
            table.add(otherContainer).expand().fill();
            return table;
        }
    }

    public static class WidgetContainer<T extends Table> extends Table {
        private Array<T> children = new Array<>();

        public void addWidget(T widget) {
            children.add(widget);
            add(widget).row();
        }

        public Array<T> getWidgets() {
            return children;
        }
    }

    public static final class StatsContainer extends WidgetContainer<StatsWidget> {
        public StatsContainer() {
            Table segment = new Table();
            this.add(segment).grow().pad(10);

            final Table subSegment1 = constructSegmentTable();
            final Table subSegment2 = constructSegmentTable();

            segment.add(subSegment1).expand().fill().pad(10);
            segment.add(subSegment2).size(100).pad(10);
            segment.row();

            final Table labelTable1 = new Table();
            final Table labelTable2 = new Table();
            labelTable1.defaults().expandX().fillX().pad(10);
            labelTable2.defaults().expandX().fillX().pad(10);

            subSegment1.add(labelTable1).expand().fill();
            subSegment1.add(labelTable2).expand().fill();
            subSegment1.row();

            StatsWidget[] widgets = new StatsWidget[]{
                new StatsWidget("Health", 100),
                new StatsWidget("Mana", 80),
                new StatsWidget("Strength", 50),
                new StatsWidget("Agility", 60),
                new StatsWidget("Intelligence", 70),
                new StatsWidget("Luck", 20)
            };

            for (int i = 0; i < 3; i++) {
                labelTable1.add(widgets[i]).fillX().expandX();
                widgets[i].setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#A59132")));
                labelTable1.row();
            }
            for (int i = 3; i < 6; i++) {
                labelTable2.add(widgets[i]).fillX().expandX();
                widgets[i].setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#A59132")));
                labelTable2.row();
            }
        }

        private Table constructSegmentTable() {
            Table table = new Table();
            table.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));
            return table;
        }
    }

    public static final class GearContainer extends WidgetContainer<GearWidget> {
        public GearContainer() {
            Table segment = new Table();
            add(segment).expand().fill(); // Make the segment fill GearContainer

            final Table subSegment = constructSegmentTable();
            final Table subSegment2 = constructSegmentTable();

            segment.defaults().fill().pad(30); // Only fill, not expand by default

            segment.add(subSegment).expandX().fillX(); // This one expands horizontally
            segment.add(subSegment2).width(300);       // This one keeps fixed width


    /*        for (int i = 0; i < 1; i++) {
                GearWidget widget = new GearWidget(SQUIRCLE);
                subSegment.add(widget).size(200); // Fixed square size
                //if ((i + 1) % 3 == 0) subSegment.row(); // New row after every 3 widgets
                addWidget(widget);
            }*/

            final Table bongo1 = new Table();
            final Table bongo2 = new Table();
            bongo1.defaults().expandX().fillX().height(60).pad(10);
            bongo2.defaults().expandX().fillX().height(60).pad(10);

            subSegment2.add(bongo1).expand().fill();
            subSegment2.add(bongo2).expand().fill();
            subSegment2.row();

            Table pringles = new Table();
            Table lays = new Table();
            Table doritos = new Table();

            pringles.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#A59132")));
            lays.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#A59132")));
            doritos.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#A59132")));

            bongo1.add(pringles).expandX().fillX().height(140).width(130).pad(10);
            bongo1.row();
            bongo1.add(lays).expandX().fillX().height(140).width(130).pad(10);
            bongo2.add(doritos).expandY().fillY().height(300).width(120).padRight(10);

            Table a = constructSegmentTable();
            Table b = constructSegmentTable();
            Table c = constructSegmentTable();
            Table d = constructSegmentTable();

            a.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#6A3911")));
            b.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#6A3911")));
            c.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#6A3911")));
            d.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#6A3911")));

            pringles.add(a).size(50);
            pringles.add(b).size(50);
            pringles.row();
            pringles.add(c).size(50);
            pringles.add(d).size(50);
        }

        private Table constructSegmentTable() {
            Table table = new Table();
            table.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));
            return table;
        }
    }

    public static final class OtherContainer extends WidgetContainer<StatsWidget> {
        public OtherContainer() {
            final Table sigma1 = constructSegmentTable();
            final Table sigma2 = constructSegmentTable();
            final Table sigma3 = constructSegmentTable();

            add(sigma1).expandX().fillX().pad(20);
            add(sigma2).expandX().fillX().pad(20);
            add(sigma3).expandX().fillX().pad(20);
        }

        private Table constructSegmentTable() {
            Table table = new Table();
            table.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));
            return table;
        }
    }

    public static final class GearWidget extends Table {
        private Image gearImage;
        @Getter
        private String imagePath;

        public GearWidget(String imagePath) {
            this.imagePath = imagePath;
            Drawable drawable = Resources.getDrawable(imagePath);
            gearImage = new Image(drawable);
            gearImage.setScaling(Scaling.fit);
            gearImage.setAlign(Align.center);

            setBackground(Resources.getDrawable(TestPage.SQUIRCLE, Color.valueOf("#FFFFFF")));
            add(gearImage).expand().fill().pad(10);
        }

        public void updateImage(String newPath) {
            this.imagePath = newPath;
            Drawable drawable = Resources.getDrawable(newPath);
            gearImage.setDrawable(drawable);
        }
    }

    public static final class StatsWidget extends Table {
        private Label nameLabel;
        private Label statLabel;

        public StatsWidget(String name, int stat) {
            setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#FFFFFF")));
            nameLabel = new Label(name, new Label.LabelStyle(new BitmapFont(), Color.BLACK));
            statLabel = new Label(String.valueOf(stat), new Label.LabelStyle(new BitmapFont(), Color.BLACK));

            add(nameLabel).left().expandX().pad(5);
            add(statLabel).right().pad(5);
        }

        public void updateStat(int newStat) {
            statLabel.setText(String.valueOf(newStat));
        }
    }
}
