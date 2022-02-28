import javax.swing.*;
class Experiment2
{
    JMenu menu, submenu, editmenu;
    JMenuItem i1, i2, i3, i4, i5, copy, cut, paste, selectAll;
    Experiment2(){
        JFrame f= new JFrame("Menu and MenuItem Example");
        JMenuBar mb=new JMenuBar();
        menu=new JMenu("Menu");
        submenu=new JMenu("Sub Menu");
        i1=new JMenuItem("Item 1");
        i2=new JMenuItem("Item 2");
        i3=new JMenuItem("Item 3");
        i4=new JMenuItem("Item 4");
        i5=new JMenuItem("Item 5");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        cut = new JMenuItem("Cut");
        selectAll = new JMenuItem("Select All");
        editmenu = new JMenu("Edit");
        editmenu.add(copy);
        editmenu.add(cut);
        editmenu.add(paste);
        editmenu.add(selectAll);
        menu.add(i1); menu.add(i2); menu.add(i3);
        submenu.add(i4); submenu.add(i5);
        menu.add(submenu);
        mb.add(menu);
        mb.add(editmenu);
        f.setJMenuBar(mb);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String args[])
    {
        new Experiment2();
    }}