package com.itamarlourenco.myforms.model.form;

import android.os.Parcel;
import android.os.Parcelable;
import com.activeandroid.Model;
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

/**
 * Created by itamarlourenco on 18/09/15.
 */
public class Form extends Model implements Parcelable {
    private String name;
    private String description;
    private MaterialDrawableBuilder.IconValue icon;
    private String tag;
    private int color;

    public Form(String name, String description, MaterialDrawableBuilder.IconValue icon, String tag, int color) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.tag = tag;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MaterialDrawableBuilder.IconValue getIcon() {
        return icon;
    }

    public void setIcon(MaterialDrawableBuilder.IconValue icon) {
        this.icon = icon;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    /**
     * For parcelabler
     * @param in
     */
    protected Form(Parcel in) {
        name = in.readString();
        description = in.readString();
        icon = (MaterialDrawableBuilder.IconValue) in.readValue(MaterialDrawableBuilder.IconValue.class.getClassLoader());
        tag = in.readString();
        color = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeValue(icon);
        dest.writeString(tag);
        dest.writeInt(color);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Form> CREATOR = new Parcelable.Creator<Form>() {
        @Override
        public Form createFromParcel(Parcel in) {
            return new Form(in);
        }

        @Override
        public Form[] newArray(int size) {
            return new Form[size];
        }
    };
}
