package net.sharetrip.flight.booking.view.farerules

import android.os.Bundle
import net.sharetrip.flight.shared.view.BaseFragment
import com.sharetrip.base.viewmodel.BaseViewModel
import net.sharetrip.flight.R
import net.sharetrip.flight.databinding.FragmentRulesFlightBinding
import net.sharetrip.flight.utils.ARG_RULES_DETAILS
import net.sharetrip.flight.utils.ARG_SELECTED_POSITION
import net.sharetrip.flight.utils.ARG_RULES

class RulesFragment : BaseFragment<FragmentRulesFlightBinding>() {
    private lateinit var rules: List<String>
    private var selectedItem: Int? = null
    lateinit var demoCollectionPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedItem = it.getBundle(ARG_RULES_DETAILS)?.getInt(ARG_SELECTED_POSITION)
            rules = it.getBundle(ARG_RULES_DETAILS)?.getStringArrayList(ARG_RULES) as List<String>
        }
    }

    override fun layoutId(): Int = R.layout.fragment_rules_flight

    override fun getViewModel(): BaseViewModel? = null

    override fun initOnCreateView() {
        demoCollectionPagerAdapter =
            PagerAdapter(childFragmentManager, rules)
        bindingView.pager.adapter = demoCollectionPagerAdapter
        bindingView.tabLayout.setupWithViewPager(bindingView.pager)
        bindingView.pager.offscreenPageLimit = 1
        bindingView.pager.currentItem = selectedItem!!
    }

    /*companion object {
        @JvmField val ARG_SELECTED_POSITION = "ARG_SELECTED_POSITION"
        @JvmField val ARG_RULES = "ARG_RULES"
    }*/
}
