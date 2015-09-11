package jp.co.ctc_g.bleexample.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import jp.co.ctc_g.bleexample.presentation.internal.di.HasComponent;

public class BaseFragment extends Fragment {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
