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
import com.bootcamp.demo.engine.widgets.WidgetsContainer;
import com.bootcamp.demo.pages.core.APage;
import lombok.Getter;

public class TestPage extends APage {
    public static String SQUIRCLE = "basics/ui-white-squircle-10";

    @Override
    protected void constructContent(Table content) {
        Table mainContainer = createMainContainer();
        Table UIOverlaySegment = new Table();
        Table powerBarSegment = new Table();

        content.setFillParent(true);
        content.add(UIOverlaySegment).growX().expandY().top();
        content.add(mainContainer).growX().expandY().bottom();
        UIOverlaySegment.add(powerBarSegment).size(225).expand().bottom();
    }

    public Table createMainContainer() {
        Table mainContainer = new Table();
        mainContainer.defaults().pad(30.0F); // FIX: use mainContainer instead of `this`
        mainContainer.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#FFFBDB")));

        Table StatsContainer = this.constructStatsSegment();
        Table GearContainer = this.constructGearSegment();
        Table ButtonsContainer = this.constructButtonSegment();

        mainContainer.add(StatsContainer).expandX().fillX().pad(20.0F).height(300.0F);
        mainContainer.row();
        mainContainer.add(GearContainer).expand().fill().pad(20.0F).height(400.0F);
        mainContainer.row();
        mainContainer.add(ButtonsContainer).expandX().fillX().pad(20.0F).height(150.0F);

        return mainContainer;
    }


    private Table constructStatsSegment() {
        Table statsSegment = new Table();
        StatsContainer statsContainer = new StatsContainer();
        Table button = new Table();
        statsSegment.add(statsContainer);
        statsSegment.add(button).size(100).pad(10);
        return statsSegment;
    }

    private Table constructGearSegment() {
        EquippedGear equippedGear = new EquippedGear();
        TacticalGear tacticalGear = new TacticalGear();

        Table table = new Table();
        table.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#30362F")));

        table.add(equippedGear).expand().fill();
        table.add(tacticalGear).expand().fill();
        return table;
    }

    public Table constructButtonSegment()
    {
        Table buttonSegment = new Table();
        buttonSegment.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));
        for (int i = 0; i < 3; i++) {
            Table button = new Table();
            button.setBackground(Resources.getDrawable(SQUIRCLE, Color.RED));
            buttonSegment.add(button).expandY();
        }
        return buttonSegment;
    }

    public static final class StatsContainer extends WidgetsContainer<StatsWidget>
    {
        public StatsContainer() {
            super(3);

            StatsWidget[] widgets = new StatsWidget[]{
                new StatsWidget("Health", 100),
                new StatsWidget("Mana", 80),
                new StatsWidget("Strength", 50),
                new StatsWidget("Agility", 60),
                new StatsWidget("Intelligence", 70),
                new StatsWidget("Luck", 20),
                new StatsWidget("Agility", 60),
                new StatsWidget("Intelligence", 70),
                new StatsWidget("Luck", 20)
            };

            for (int i = 0; i < 9; i++) {
                add(widgets[i]);
                widgets[i].setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#A59132")));
            }
        }
    }

    public Table createGearSegment()
    {
        Table gearSegment = new Table();
        Table equippedGearWrapper = new Table();
        Table tacticalGearWrapper = new Table();
        EquippedGear equippedGear = new EquippedGear();
        TacticalGear tacticalGear = new TacticalGear();
        gearSegment.setBackground(Resources.getDrawable(SQUIRCLE, Color.WHITE));

        gearSegment.add(equippedGearWrapper);
        gearSegment.add(tacticalGearWrapper);
        equippedGearWrapper.add(equippedGear);
        tacticalGearWrapper.add(tacticalGear);
        return gearSegment;
    }

    public static final class EquippedGear extends WidgetsContainer<GearWidget>
    {
        public EquippedGear() {
            super(3);
            defaults().fill().pad(30); // Only fill, not expand by default
            for (int i = 0; i < 6; i++) {
                GearWidget widget = new GearWidget(SQUIRCLE);
                add(widget); // Fixed square size
            }
        }
    }

    public static final class TacticalGear extends WidgetsContainer<TacticalWidget>
    {
        public TacticalGear() {
            super(3);
            for (int i = 0; i < 3; i++) {
                TacticalWidget tacticalWidget = new TacticalWidget(SQUIRCLE);
                add(tacticalWidget);
                if (i == 0)
                {
                    for (int j = 0; j < 4; j++) {
                        TacticalWidget subWidgets = new TacticalWidget(SQUIRCLE);
                        add(subWidgets);
                    }
                }
            }
        }
    }

    public static final class GearWidget extends Table
    {
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

    public static final class TacticalWidget extends Table
    {
        private Image gearImage;
        @Getter
        private String imagePath;

        public TacticalWidget(String imagePath) {
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

    public static final class StatsWidget extends Table
    {
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
