package net.sharetrip.view.booking

import android.content.Intent
import com.sharetrip.base.data.PrefKey
import com.sharetrip.base.data.SharedPrefsHelper
import com.sharetrip.base.event.EventObserver
import com.sharetrip.base.view.BaseFragment
import com.sharetrip.base.viewmodel.BaseViewModel
import net.sharetrip.R
import net.sharetrip.databinding.FragmentBookingBinding
import net.sharetrip.flight.history.FlightHistoryActivity
import net.sharetrip.network.MainDataManager
import net.sharetrip.view.dashboard.DashboardActivity
import java.text.NumberFormat
import java.util.*

class BookingFragment : BaseFragment<FragmentBookingBinding>() {

    private val viewModel: BookingViewModel by lazy {
        BookingVMFactory(
            MainDataManager.getSharedPref(requireContext())
        ).create(BookingViewModel::class.java)
    }

    override fun layoutId(): Int = R.layout.fragment_booking

    override fun getViewModel(): BaseViewModel = viewModel

    override fun initOnCreateView() {
        bindingView.viewModel = viewModel
        //bindingView.guestLayout.data = viewModel.popupData

//        viewModel.navigateToTourHistory.observe(viewLifecycleOwner, EventObserver{
//            val intent = Intent(requireContext(), TourHistoryActivity::class.java)
//            startActivity(intent)
//        })

        viewModel.gotoFlightBookingHistory.observe(viewLifecycleOwner, EventObserver {
            val intent = Intent(requireContext(), FlightHistoryActivity::class.java)
            startActivity(intent)
        })

        viewModel.navigateToHoliday.observe(viewLifecycleOwner, EventObserver {
            /*val intent = Intent(requireContext(), HolidayHistoryActivity::class.java)
            startActivity(intent)*/
        })

        viewModel.gotoFlightHotelHistory.observe(viewLifecycleOwner, EventObserver {
            /*val intent = Intent(requireContext(), HotelHistoryActivity::class.java)
            startActivity(intent)*/
        })

        viewModel.gotoBusHistory.observe(viewLifecycleOwner, EventObserver {
            //val intent = Intent(requireContext(), BusHistoryActivity::class.java)
            //startActivity(intent)
        })

        viewModel.gotoVisaHistory.observe(viewLifecycleOwner, EventObserver {
            /*val intent = Intent(requireContext(), VisaHistoryActivity::class.java)
            startActivity(intent)*/
        })

        var points = SharedPrefsHelper(requireContext())[PrefKey.USER_TRIP_COIN, ""]
        points = points.filter { it in '0'..'9' }
        if (points.isBlank()) {
            points = "0"
            SharedPrefsHelper(requireContext()).put(PrefKey.USER_TRIP_COIN, "0")
        }

        viewModel.navigateToLogin.observe(viewLifecycleOwner, EventObserver {

        })

        bindingView.textViewTripCoin.text =
            NumberFormat.getNumberInstance(Locale.US).format(points.toInt())
    }


}