package com.bootcamp.demo.pages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Scaling;
import com.bootcamp.demo.engine.Resources;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.pages.core.APage;

public class TestPage extends APage {
    @Override
    protected void constructContent (Table content) {

        final Table grid = constructGrid();
        content.setFillParent(true);
        content.add(grid);
        //content.debugAll(); //this draws the frames around the tables
    }

    public Table constructGrid() {
        final int rows = 3;
        final int cols = 3;


// Main Table

        final Table gridTable = new Table();
        gridTable.pad(30).defaults().width(1000).height(1000).space(30); // only height
        gridTable.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#FFFBDB")));
        gridTable.defaults().expand().fill();


// 3 containers

        final Table segment1 = constructSegment1();
        segment1.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#30362F")));

        final Table segment2 = constructSegment1();
        segment2.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#30362F")));

        final Table segment3 = constructSegment1();
        segment3.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#30362F")));

        gridTable.add(segment1).height(300).expandX().fillX(); // adjust height
        gridTable.row();
        gridTable.add(segment2).height(400).expandX().fillX();
        gridTable.row();
        gridTable.add(segment3).height(150).expandX().fillX();

        segment1.defaults().expand().fill();
        segment3.defaults().expand().fill();
        segment2.defaults().expand().fill();



// SUBSEGMENT 1 - 6 Labels
        final Table subSegment1 = constructSegment1();
        subSegment1.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#625834")));

        final Table subSegment2 = constructSegment1();
        subSegment2.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#625834")));

// Add subsegments to main segment table
        segment1.add(subSegment1).width(800).pad(20).expand().fill();
        segment1.add(subSegment2).width(120).height(120).pad(20); // Adjust width as needed
        segment1.row();

// Split subSegment1 into two vertical label containers
        final Table labelTable1 = new Table();
        final Table labelTable2 = new Table();
        labelTable1.defaults().expandX().fillX().height(60).width(350).pad(10);
        labelTable2.defaults().expandX().fillX().height(60).width(350).pad(10);

        subSegment1.add(labelTable1).expand().fill();
        subSegment1.add(labelTable2).expand().fill();
        subSegment1.row();

// Create label containers with background
        Table[] labels = new Table[6];
        for (int i = 0; i < 6; i++) {
            labels[i] = constructSegment1();
            labels[i].setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#A59132")));
        }

// Add 3 labels per column
        for (int i = 0; i < 3; i++) {
            labelTable1.add(labels[i]);
            labelTable1.row();
        }
        for (int i = 3; i < 6; i++) {
            labelTable2.add(labels[i]);
            labelTable2.row();
        }



        /// ///// SEGMENT 2


        final Table subSegment3 = constructSegment1();
        subSegment3.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#625834")));

        final Table subSegment4 = constructSegment1();
        subSegment4.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#625834")));

// Add subsegments to main segment table
        segment2.add(subSegment3).width(600).height(350).pad(5).expand().fill();
        segment2.add(subSegment4).width(300).height(350).pad(5); // Adjust width as needed
        segment2.row();

        Table[] crocodillos = new Table[6];
        for (int i = 0; i < 6; i++) {
            crocodillos[i] = constructSegment1();
            crocodillos[i].setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#A59132")));
        }

        for (int i = 0; i < 3; i++) {
            subSegment3.add(crocodillos[i]).size(140).pad(10);
        }
        subSegment3.row();
        for (int i = 3; i < 6; i++) {
            subSegment3.add(crocodillos[i]).size(140).pad(10);
        }

        // creating two invisible tables in subsegment4
        final Table bongo1 = new Table();
        final Table bongo2 = new Table();
        bongo1.defaults().expandX().fillX().height(60).pad(10);
        bongo2.defaults().expandX().fillX().height(60).pad(10);

        subSegment4.add(bongo1).expand().fill();
        subSegment4.add(bongo2).expand().fill();
        subSegment4.row();

        Table pringles = constructSegment1();
        Table lays = constructSegment1();
        Table doritos = constructSegment1();

        pringles.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#A59132")));
        lays.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#A59132")));
        doritos.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#A59132")));

        bongo1.add(pringles).expandX().fillX().height(140).width(130).pad(10);
        bongo1.row();
        bongo1.add(lays).expandX().fillX().height(140).width(130).pad(10);
        bongo2.add(doritos).expandY().fillY().height(300).width(120).padRight(10);

        Table a = constructSegment1();
        Table b = constructSegment1();
        Table c = constructSegment1();
        Table d = constructSegment1();

        a.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#6A3911")));
        b.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#6A3911")));
        c.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#6A3911")));
        d.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#6A3911")));

        pringles.add(a).size(50);
        pringles.add(b).size(50);
        pringles.row();
        pringles.add(c).size(50);
        pringles.add(d).size(50);




      /// ///// SEGMENT 3

        final Table sigma1 = constructSegment1();
        final Table sigma2 = constructSegment1();
        final Table sigma3 = constructSegment1();

        sigma1.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#625834")));
        sigma2.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#625834")));
        sigma3.setBackground(Resources.getDrawable("basics/white-squircle-35", Color.valueOf("#625834")));

        segment3.add(sigma1).expandX().fillX().pad(20);
        segment3.add(sigma2).expandX().fillX().pad(20);
        segment3.add(sigma3).expandX().fillX().pad(20);

        return gridTable;
    }

    public Table constructSegment1(){
        final Table segment1 = new Table();
        return segment1;
    }

}
