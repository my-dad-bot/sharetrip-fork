package net.sharetrip.view.profile.dashboard


import com.sharetrip.base.view.BaseFragment
import com.sharetrip.base.viewmodel.BaseViewModel
import net.sharetrip.R
import net.sharetrip.databinding.FragmentProfileDashboardBinding

class ProfileDashboardFragment : BaseFragment<FragmentProfileDashboardBinding>(){


    override fun layoutId(): Int = R.layout.fragment_profile_dashboard

    override fun getViewModel(): BaseViewModel? = null

    override fun initOnCreateView() {
    }
    
}
