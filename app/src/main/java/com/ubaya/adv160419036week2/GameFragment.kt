package com.ubaya.adv160419036week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var num1 = 0
        var num2 = 0
        fun randomQuestion() {
            num1 = (0..100).random()
            num2 = (0..100).random()
            txtQuestion.text = "$num1 + $num2"
        }

        randomQuestion()
        var correct = 0

        btnSubmit.setOnClickListener { 
            if (num1 + num2 == txtAnswer.text.toString().toInt()) {
                correct++
                randomQuestion()
                txtAnswer.setText("")
            } else {
                val action = GameFragmentDirections.actionResultFragment(correct)
                Navigation.findNavController(it).navigate(action)
            }
        }

        if(arguments!=null) {
            var playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
    }

}