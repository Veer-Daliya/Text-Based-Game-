//Class Player
public class Player {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private Weapon myWeapon;
    private World myWorld;
    private Item myItem;

    public Player(String name, int maxHp, int attack, int defense, Weapon myWeapon,  World myWorld, Item myItem) {
        this.name = name;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.myWeapon = myWeapon;
        this.myWorld = myWorld;
        this.myItem = myItem;
        this.hp = maxHp;


    }

    //Getters

    public String getName()
    {
        return this.name;
    }

    public int getMaxHp()
    {
        return this.maxHp;
    }

    public int getAttack()
    {
        return this.attack;
    }

    public int getDefense()
    {
        return this.defense;
    }

    public Weapon getWeapon()
    {
        return this.myWeapon;
    }

    public World getWorld()
    {
        return this.myWorld;
    }

    public int getHp()
    {
        return this.hp;
    }

    public Item getMyItem()
    {
        return this.myItem;
    }



    public void setHp(int hp)
    {
        this.hp = hp;
    }



    //This method makes sure that the potion heals the player
    //So for this method,
    //potion heals 50 hp, then is discarded (Max 100 hp)
    //enemy has small chance to also hold potion instead of sword
    //critical hit chance, ~15% chance






    //Uses Item and heals the person

    public void useItem() {
        if(myItem != null) {
            this.hp += myItem.getHealAmount();
            if (this.hp > this.maxHp) {
                this.hp = this.maxHp;
            }
            System.out.println(this.name + " has healed " + myItem.getHealAmount() +" HP");
            myItem = null;
        }
        else {
            System.out.println ("You have no item to use.");
        }

    }






    //This method checks whether or not this player is alive
    public boolean isAlive() {
        return hp > 0;
    }




    public void attack(Enemy enemy) {
        int hp = enemy.getHp() - (this.attack + this.myWeapon.getDamage());
        enemy.setHp(hp);

    }




    public void setWeapon(Weapon weapon)
    {
        this.myWeapon = weapon;
    }

    public void setItem(Item item)
    {
        this.myItem = item;
    }




    public String toString() {
        return this.name + "HP: "
                + this.hp + "/" + this.maxHp;
    }





















}

