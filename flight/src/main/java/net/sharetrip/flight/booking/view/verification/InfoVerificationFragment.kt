package net.sharetrip.flight.booking.view.verification

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.sharetrip.base.data.SharedPrefsHelper
import com.sharetrip.base.event.EventObserver
import net.sharetrip.flight.shared.utils.hideKeyboard
import net.sharetrip.flight.shared.utils.navigateSafe
import net.sharetrip.flight.shared.utils.setTitleAndSubtitle
import net.sharetrip.flight.shared.view.BaseFragment
import com.sharetrip.base.viewmodel.BaseViewModel
import net.sharetrip.flight.R
import net.sharetrip.flight.booking.model.FlightSearch
import net.sharetrip.flight.booking.model.ItemTraveler
import net.sharetrip.flight.booking.model.coupon.CouponResponse
import net.sharetrip.flight.booking.model.flightresponse.DiscountModel
import net.sharetrip.flight.booking.model.flightresponse.flights.Flights
import net.sharetrip.flight.databinding.FragmentUserVerificationOfFlightBinding
import net.sharetrip.flight.utils.*

class InfoVerificationFragment : BaseFragment<FragmentUserVerificationOfFlightBinding>() {
    private val viewModel: InfoVerificationViewModel by lazy {
        InfoVerificationViewModelFactory(
            itemTravelers,
            SharedPrefsHelper(requireContext())
        ).create(InfoVerificationViewModel::class.java)
    }
    private lateinit var adapter: InfoVerificationAdapter
    private lateinit var itemTravelers: MutableList<ItemTraveler>
    private val focusChangeListener =
        View.OnFocusChangeListener { _, hasFocus -> if (!hasFocus) hideKeyboard() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemTravelers = requireArguments().getBundle(ARG_ALL_TRAVELLER_AND_DATA)
            ?.getParcelableArrayList(ARG_ALL_TRAVELLER)!!
    }

    override fun layoutId() = R.layout.fragment_user_verification_of_flight

    override fun getViewModel(): BaseViewModel = viewModel

    override fun initOnCreateView() {
        bindingView.viewModel = viewModel

        adapter = InfoVerificationAdapter(itemTravelers, viewModel)
        bindingView.userInformationList.adapter = adapter
        bindingView.editContactNumber.onFocusChangeListener = focusChangeListener

        viewModel.msg.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.onShowImageClicked.observe(viewLifecycleOwner, EventObserver {
            val bundle = Bundle()
            when (viewModel.imageTag) {
                "passport" -> {
                    bundle.putString(ARG_IMAGE_URL, it)
                    bundle.putString(
                        ARG_IMAGE_TAG,
                        getString(R.string.passport_copy_preview)
                    )
                    findNavController().navigateSafe(
                        R.id.action_infoVerification_to_imagePreview,
                        bundleOf(ARG_IMAGE_DATA to bundle)
                    )
                }
                "visa" -> {
                    bundle.putString(ARG_IMAGE_URL, it)
                    bundle.putString(
                        ARG_IMAGE_TAG,
                        getString(R.string.visa_copy_preview)
                    )
                    findNavController().navigateSafe(
                        R.id.action_infoVerification_to_imagePreview,
                        bundleOf(ARG_IMAGE_DATA to bundle)
                    )
                }
            }
        })

        viewModel.onContinueClicked.observe(viewLifecycleOwner, EventObserver {
            val bundle = Bundle()
            val flights = requireArguments().getBundle(ARG_ALL_TRAVELLER_AND_DATA)
                ?.getParcelable<Flights>(ARG_FLIGHTS)
            val flightSearch = requireArguments().getBundle(ARG_ALL_TRAVELLER_AND_DATA)
                ?.getParcelable<FlightSearch>(ARG_FLIGHT_SEARCH)
            val discountModel = requireArguments().getBundle(ARG_ALL_TRAVELLER_AND_DATA)
                ?.getParcelable<DiscountModel>(ARG_DISCOUNT_MODEL)
            val couponResponse = requireArguments().getBundle(ARG_ALL_TRAVELLER_AND_DATA)
                ?.getParcelable<CouponResponse>(ARG_COUPON_RESPONSE)
            bundle.putParcelable(ARG_FLIGHT_SEARCH, flightSearch)
            bundle.putParcelable(ARG_FLIGHTS, flights)
            bundle.putParcelable(ARG_DISCOUNT_MODEL, discountModel)
            bundle.putParcelable(ARG_COUPON_RESPONSE, couponResponse)
            bundle.putParcelableArrayList(
                ARG_ALL_TRAVELLER,
                itemTravelers as ArrayList<ItemTraveler>
            )
            findNavController().navigateSafe(
                R.id.action_infoVerification_to_bookingSummary,
                bundleOf(ARG_FLIGHT_DATA to bundle)
            )
        })
    }

    override fun onStart() {
        super.onStart()
        setTitleAndSubtitle(getString(R.string.verify_info))
    }
}
