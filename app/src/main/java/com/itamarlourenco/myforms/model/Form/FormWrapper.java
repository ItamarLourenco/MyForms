package com.itamarlourenco.myforms.model.Form;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import com.itamarlourenco.myforms.R;
import com.itamarlourenco.myforms.application.App;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itamarlourenco on 18/09/15.
 */
public class FormWrapper implements Parcelable {
    private     List<Form> formList = new ArrayList<>();

    public List<Form> getList(){
        formList.add(new Form("Primeiro Formulário", App.getContext().getString(R.string.apagar), MaterialDrawableBuilder.IconValue.ACCOUNT, "Esporte", Color.BLUE));
        formList.add(new Form("Segundo Formulário", App.getContext().getString(R.string.apagar), MaterialDrawableBuilder.IconValue.BELL_SLEEP, "Entreterimento", Color.RED));
        formList.add(new Form("Terceiro Formulário", App.getContext().getString(R.string.apagar), MaterialDrawableBuilder.IconValue.ACCOUNT, "Case", Color.GREEN));
        formList.add(new Form("Quarto Formulário", App.getContext().getString(R.string.apagar), MaterialDrawableBuilder.IconValue.ACCOUNT, "Escritório", Color.GRAY));
        formList.add(new Form("Quinto Formulário", App.getContext().getString(R.string.apagar), MaterialDrawableBuilder.IconValue.ACCOUNT, "Televisao", Color.YELLOW));
        return formList;
    }

    public FormWrapper() {
    }

    protected FormWrapper(Parcel in) {
        formList = in.createTypedArrayList(Form.CREATOR);
    }

    public static final Creator<FormWrapper> CREATOR = new Creator<FormWrapper>() {
        @Override
        public FormWrapper createFromParcel(Parcel in) {
            return new FormWrapper(in);
        }

        @Override
        public FormWrapper[] newArray(int size) {
            return new FormWrapper[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(formList);
    }
}
