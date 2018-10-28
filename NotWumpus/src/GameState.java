import java.awt.*;

public class GameState extends State
{

    private Player player;
    private Monster monster;
    private World world;

    public GameState(Handler handler)
    {
        super(handler);

        world = new World(handler, "res/worlds/world1.txt");
        player = new Player(handler, 100, 100);
        //passes world through handler
        handler.setWorld(world);
        //Places the player
        monster = new Monster(handler, 100, 200);
    }

    public void update()
    {
        world.update();
        player.update();
    }

    public void render(Graphics g)
    {
        world.render(g);
        monster.render(g);
        player.render(g);

        //Menu Stuff
        g.drawImage(Asset.tMenu1, 900, 618, null);

        //
        int fontSize = 20;
        g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
        g.setColor(Color.white);
        g.drawString("Move Direction", 975, 640);

        //
        g.setColor(Color.black);
        g.drawString("End Turn", 1005, 730);
    }
}