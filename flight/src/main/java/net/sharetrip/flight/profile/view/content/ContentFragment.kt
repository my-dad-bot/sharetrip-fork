package net.sharetrip.flight.profile.view.content

import android.view.View
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.core.text.HtmlCompat.fromHtml
import androidx.fragment.app.viewModels
import com.sharetrip.base.data.PrefKey
import com.sharetrip.base.viewmodel.BaseViewModel
import net.sharetrip.flight.R
import net.sharetrip.flight.databinding.FragmentContentFlightBinding
import net.sharetrip.flight.profile.model.FaqItem
import net.sharetrip.flight.profile.network.DataManager
import net.sharetrip.flight.shared.utils.hideTripCoin
import net.sharetrip.flight.shared.utils.setTitleAndSubtitle
import net.sharetrip.flight.shared.utils.showTripCoin
import net.sharetrip.flight.shared.view.BaseFragment

class ContentFragment : BaseFragment<FragmentContentFlightBinding>() {

    private val viewModel: ContentViewModel by viewModels {
        val faqNumber = arguments?.getInt(ARG_FAQ_NUMBER)
        ContentViewModelFactory(faqNumber!!, ContentRepo(DataManager.profileApiService))
    }

    override fun layoutId() = R.layout.fragment_content_flight

    override fun getViewModel(): BaseViewModel = viewModel

    override fun initOnCreateView() {
        val sharedPrefsHelper = DataManager.getSharedPref(requireContext())
        val faqNumber = arguments?.getInt(ARG_FAQ_NUMBER)

        when (faqNumber) {
            ARG_TERMS_AND_CONDITION_TRIVIA, ARG_TERMS_AND_CONDITION_COMMON -> {
                setTitleAndSubtitle(getString(R.string.term_and_condition))
            }

            ARG_PRIVACY_POLICY -> {
                setTitleAndSubtitle(getString(R.string.privacy_policy))
            }

            else -> {
                setTitleAndSubtitle(getString(R.string.profile))
            }
        }

        viewModel.faqResponse.observe(viewLifecycleOwner) {
            setContent(it)
        }

        viewModel.tocResponse.observe(viewLifecycleOwner) {
            setContent(it)
        }

        when (faqNumber) {
            ARG_PRIVACY_POLICY -> {
                val title =
                    getString(R.string.privacy_policy_title_html)
                val body =
                    getString(R.string.privacy_policy_body_html)
                setContent(FaqItem(title, body))
            }

            ARG_TERMS_AND_CONDITION_TRIVIA -> {
                val title =
                    getString(R.string.term_condition_title_trivia)
                val body =
                    sharedPrefsHelper[PrefKey.QUIZ_TERM_AND_CONDITION, ""]
                setContent(FaqItem(title, body))
            }

            ARG_FAQ_TRAVEL_TRIVIA -> {
                val title =
                    getString(R.string.term_condition_title_trivia)
                val body = sharedPrefsHelper[PrefKey.QUIZ_FAQ, ""]
                setContent(FaqItem(title, body))
            }

            ARG_READ_RULES -> {
                setTitleAndSubtitle("How To Read Rules")
                val title = ""
                val body = getString(R.string.read_rules)
                setContent(FaqItem(title, body))
            }

            ARG_TERMS_AND_CONDITION_SPIN_TO_WIN, ARG_TERMS_AND_CONDITION_LOYALTY, ARG_TERMS_AND_CONDITION_COMMON -> {
                viewModel.loadTOCData()
            }

            else -> {
                viewModel.loadFAQData()
            }
        }
    }

    private fun setContent(faqItem: FaqItem) {
        if (faqItem.title.isEmpty()) {
            bindingView.textViewTitle.visibility = View.GONE
        } else {
            bindingView.textViewTitle.text = faqItem.title
        }
        bindingView.textViewDescription.text = fromHtml(faqItem.body,FROM_HTML_MODE_LEGACY)
        bindingView.progressBar.visibility = View.GONE
    }

    override fun onStart() {
        super.onStart()
        hideTripCoin()
    }

    override fun onStop() {
        super.onStop()
        showTripCoin()
    }

    companion object {
        const val ARG_FAQ_NUMBER = "faq_number"
        const val ARG_PRIVACY_POLICY = 0

        const val ARG_FAQ_COMMON = 1
        const val ARG_FAQ_HOTEL = 2
        const val ARG_FAQ_FLIGHT = 3
        const val ARG_FAQ_HOLIDAY = 4
        const val ARG_FAQ_TOUR = 5
        const val ARG_FAQ_TRANSFER = 6
        const val ARG_FAQ_TRIP_COIN = 7
        const val ARG_FAQ_TRAVEL_TRIVIA = 8

        const val ARG_TERMS_AND_CONDITION_COMMON = 9
        const val ARG_TERMS_AND_CONDITION_SPIN_TO_WIN = 10
        const val ARG_TERMS_AND_CONDITION_LOYALTY = 11
        const val ARG_TERMS_AND_CONDITION_TRIVIA = 12
        const val ARG_READ_RULES = 13


        const val SUCCESS = "SUCCESS"
        const val PROFILE_PICTURE_UPDATED = "Profile Picture successfully updated"
        const val PASSPORT_UPLOADED = "Uploaded!! Now Save the data"
        const val PROFILE_NOT_UPDATED = "User Profile not updated"
        const val PROFILE_UPDATED = "User Profile updated"
        const val INVALID_BIRTHDATE =
            "The information provided is not valid, kindly provide the valid date of birth"
        const val PARSE_ERROR = "An error happen to parse"
        const val ENTER_PASSPORT_NUMBER = "Please enter passport number"
        const val ENTER_PASSPORT_EXPIRY_DATE = "Please enter passport expiry date"
        const val INVALID_PASSPORT = "Invalid passport number"
        const val ENTER_VALID_PHONE =
            "Please provide a valid phone number with proper country code."
        const val EMPTY_MOBILE = "Mobile number is empty!"
        const val INVALID_NAME_FORMAT = "Invalid Name Format"
    }
}
