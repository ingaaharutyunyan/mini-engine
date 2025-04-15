package com.bootcamp.demo.pages;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.bootcamp.demo.engine.Resources;
import com.bootcamp.demo.engine.widgets.WidgetsContainer;
import com.bootcamp.demo.pages.core.APage;
import lombok.Getter;

public class TestPage extends APage {
    public static String SQUIRCLE = "basics/ui-white-squircle-15";
    public static String SQUIRCLE_BORDER = "basics/ui-white-squircle-border-16";
    public static String SQUIRCLE_TOP = "basics/ui-white-squircle-top-20";

    @Override
    protected void constructContent(Table content) {
        Table mainContainer = createMainContainer();
        Table powerBarSegment = new Table();
        powerBarSegment.setBackground(Resources.getDrawable(SQUIRCLE_TOP, Color.valueOf("#a59132")));

        // Main layout structure
        content.setFillParent(true);

        // Stack power bar above main container
        Table verticalGroup = new Table();
        verticalGroup.add(powerBarSegment).size(350, 100).padBottom(10).row(); // Add some bottom padding
        verticalGroup.add(mainContainer).growX().expandY();

        // Center the stack in the parent
        content.add(verticalGroup).growX().expandY().bottom();
    }


    public Table createMainContainer() {
        Table mainContainer = new Table();
        mainContainer.defaults().pad(30.0F); // FIX: use mainContainer instead of `this`
        mainContainer.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#FFFBDB")));

        Table StatsContainer = this.constructStatsSegment();
        Table GearContainer = this.constructGearSegment();
        Table ButtonsContainer = this.constructButtonSegment();

        mainContainer.add(StatsContainer).expandX().fillX().pad(20.0F).height(200.0F);
        mainContainer.row();
        mainContainer.add(GearContainer).expand().fill().pad(20.0F).height(400.0F);
        mainContainer.row();
        mainContainer.add(ButtonsContainer).expandX().fillX().pad(20.0F).height(150.0F);

        return mainContainer;
    }


    private Table constructStatsSegment() {
        Table statsSegment = new Table();
        Table button = new Table();
        StatsContainer statsContainer = new StatsContainer();

        statsSegment.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#30362f")));
        button.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));
        statsContainer.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));

        // Main layout - stats on left, button on right
        statsSegment.add(statsContainer).expand().fill().pad(10);
        statsSegment.add(button).size(100).pad(10);

        return statsSegment;
    }

    private Table constructGearSegment() {
        Table gearSegment = new Table();
        EquippedGear equippedGear = new EquippedGear();
        Table tacticalGearContainer = new Table();
        TacticalGear tacticalGear = new TacticalGear();
        Table petContainer = new Table();

        gearSegment.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#30362f")));
        tacticalGearContainer.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));
        petContainer.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#FFFFFF")));

        gearSegment.add(equippedGear).expandX().fillX().pad(10);
        gearSegment.add(tacticalGearContainer).expandX().fillX().pad(10);
        tacticalGearContainer.add(tacticalGear);
        tacticalGearContainer.add(petContainer).height(350).width(150).expandX().fillX().pad(10);
        return gearSegment;
    }

    public Table constructButtonSegment()
    {
        Table buttonSegment = new Table();
        buttonSegment.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#30362f")));
        for (int i = 0; i < 3; i++) {
            Table button = new Table();
            button.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));
            buttonSegment.add(button).grow().height(120).pad(20);
        }
        return buttonSegment;
    }

    public static final class StatsContainer extends WidgetsContainer<StatsWidget>
    {
        public StatsContainer() {
            super(3);
            defaults().expandX().fillX().height(50).pad(5);

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
                super.add(widgets[i]);
                widgets[i].setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#A59132")));
            }
        }
    }

    public static final class EquippedGear extends WidgetsContainer<GearWidget>
    {
        public EquippedGear() {
            super(3);
            defaults().size(180).pad(10); // Only fill, not expand by default
            setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));
            for (int i = 0; i < 6; i++) {
                GearWidget widget = new GearWidget(SQUIRCLE);
                Table border = new Table();
                border.setBackground(Resources.getDrawable(SQUIRCLE_BORDER, Color.valueOf("#695E1F")));
                add(widget); // Fixed square size
                add(border).expand().fill().pad(4);
            }
        }
    }

    public static final class TacticalGear extends WidgetsContainer<TacticalWidget>
    {
        public TacticalGear() {
            super(1);
            defaults().size(140).pad(10);
            setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#625834")));

            for (int i = 0; i < 2; i++) {
                TacticalWidget tacticalWidget = new TacticalWidget(SQUIRCLE);
                add(tacticalWidget);
                if (i == 0)
                {
                    Table subContainer = new Table();
                    subContainer.defaults().size(50).pad(5);

                    // Add 4 sub-widgets in 2 rows
                    for (int row = 0; row < 2; row++) {
                        for (int col = 0; col < 2; col++) {
                            Table subWidget = new Table();
                            subWidget.setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#1e1f22")));
                            subContainer.add(subWidget);
                        }
                        subContainer.row(); // New row after every 2 widgets
                    }
                    tacticalWidget.add(subContainer);
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

            setBackground(Resources.getDrawable(TestPage.SQUIRCLE, Color.valueOf("#a59132")));
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

    public static final class StatsWidget extends Table {
        private Label nameLabel;
        private Label statLabel;

        public StatsWidget(String name, int stat) {
            setBackground(Resources.getDrawable(SQUIRCLE, Color.valueOf("#FFFFFF")));

            // Create font with scaled size (2x default size)
            BitmapFont font = new BitmapFont();
            font.getData().setScale(3.0f); // Adjust scale factor as needed

            nameLabel = new Label(name, new Label.LabelStyle(font, Color.BLACK));
            statLabel = new Label(String.valueOf(stat), new Label.LabelStyle(font, Color.BLACK));

            add(nameLabel).left().expandX().fillX().pad(5);
            add(statLabel).right().expandX().fillX().pad(5);
        }

        public void updateStat(int newStat) {
            statLabel.setText(String.valueOf(newStat));
        }
    }
}
