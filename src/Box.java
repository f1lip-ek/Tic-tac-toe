public class Box {

    private String ikona = "N";
    private boolean isActive;
    private Entity entity;

    public Box(){
        this.isActive = false;
    }

    public Entity getEntity(){
        return this.entity;
    }


    public boolean isActive(){
        return this.isActive;
    }

    public void setActive(EntityClass e){
        this.isActive = true;
        this.ikona = e.getIcon();
        this.entity = e.entity;
    }

    public String toString(){
        return this.ikona;
    }

}
