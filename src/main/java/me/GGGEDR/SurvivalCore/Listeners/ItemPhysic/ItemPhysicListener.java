package me.GGGEDR.SurvivalCore.Listeners.ItemPhysic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class ItemPhysicListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
                ArmorStand armorStand = e.getItemDrop().getLocation().getWorld().spawn(e.getItemDrop().getLocation().set(e.getItemDrop().getLocation().getX(), e.getItemDrop().getLocation().getY() - 2.1, e.getItemDrop().getLocation().getZ()), ArmorStand.class);
                armorStand.setGravity(false);
                armorStand.setItem(EquipmentSlot.HAND, e.getItemDrop().getItemStack());
                armorStand.setVisible(false);
                armorStand.setRightArmPose(EulerAngle.ZERO);
                spawnName(e, armorStand);
                e.getItemDrop().remove();
    }

    public void spawnName(PlayerDropItemEvent e, ArmorStand a){
        ArmorStand armorStand = e.getItemDrop().getLocation().getWorld().spawn(getArmTip(a).set(getArmTip(a).getX(), getArmTip(a).getY() - 1.8, getArmTip(a).getZ()), ArmorStand.class);
        armorStand.setGravity(false);
        armorStand.setCustomName("§c"+ e.getItemDrop().getName() +" §f"+e.getItemDrop().getItemStack().getAmount() +"x");
        armorStand.setVisible(false);
        armorStand.setCustomNameVisible(true);
        e.getItemDrop().remove();
    }

    public static Location getArmTip(ArmorStand as) {
        // Gets shoulder location
        Location asl = as.getLocation().clone();
        asl.setYaw(asl.getYaw() + 90f);
        Vector dir = asl.getDirection();
        asl.setX(asl.getX() + 5f / 16f * dir.getX());
        asl.setY(asl.getY() + 22f / 16f);
        asl.setZ(asl.getZ() + 5f / 16f * dir.getZ());
        asl.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, asl, 1);
        // Get Hand Location

        EulerAngle ea = as.getRightArmPose();
        Vector armDir = getDirection(ea.getY(), ea.getX(), -ea.getZ());
        armDir = rotateAroundAxisY(armDir, Math.toRadians(asl.getYaw()-90f));
        asl.setX(asl.getX() + 10f / 16f * armDir.getX());
        asl.setY(asl.getY() + 10f / 16f * armDir.getY());
        asl.setZ(asl.getZ() + 10f / 16f * armDir.getZ());

        asl.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, asl, 1);
        return asl;
    }

    public static Vector getDirection(Double yaw, Double pitch, Double roll) {
        Vector v = new Vector(0, -1, 0);
        v = rotateAroundAxisX(v, pitch);
        v = rotateAroundAxisY(v, yaw);
        v = rotateAroundAxisZ(v, roll);
        return v;
    }

    private static Vector rotateAroundAxisX(Vector v, double angle) {
        double y, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    private static Vector rotateAroundAxisY(Vector v, double angle) {
        angle = -angle;
        double x, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos + v.getZ() * sin;
        z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    private static Vector rotateAroundAxisZ(Vector v, double angle) {
        double x, y, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos - v.getY() * sin;
        y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }
}
