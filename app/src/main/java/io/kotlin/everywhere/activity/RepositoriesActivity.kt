/**
 * Created by [Author].
 */

package io.kotlin.everywhere.activity

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.support.v7.widget.Toolbar
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.content.Intent
import io.kotlin.everywhere.R
import io.kotlin.everywhere.adapter.RepositoriesActivityViewRecyclerViewAdapter
import android.widget.EditText
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import io.kotlin.everywhere.presentation.RepositoriesViewModel


class RepositoriesActivity: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
		
			// Fill the created intent with the data you want to be passed to this Activity when it's opened.
			return Intent(context, RepositoriesActivity::class.java)
		}
	}
	
	private lateinit var toolbar: Toolbar
	private lateinit var viewRecyclerView: RecyclerView
	private lateinit var searchEditText: EditText

	private val viewModel = RepositoriesViewModel()

	
	override fun onCreate(savedInstanceState: Bundle?) {
	
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.repositories_activity)
		this.init()
	}


	override fun onDestroy() {
		this.viewModel.terminate()
		super.onDestroy()
	}


	fun setupToolbar() {

		setSupportActionBar(toolbar)

		// Additional Toolbar setup code can go here.
	}

	
	private fun init() {
	
		// Configure Navigation Bar #1 component
		toolbar = this.findViewById(R.id.toolbar)

		searchEditText = this.findViewById(R.id.search_edit_text)
		searchEditText.addTextChangedListener(object: TextWatcher {

			override fun afterTextChanged(s: Editable) {
				viewModel.query = s.toString()
			}

			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

			}

			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

			}

		})
		
		// Configure View component
		viewRecyclerView = this.findViewById(R.id.view_recycler_view)
		viewRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
		val adapter = RepositoriesActivityViewRecyclerViewAdapter(this.viewModel.lastDownloadedRepos)
		viewRecyclerView.adapter = adapter

		viewModel.onDataUpdated = {
			adapter.items = it
			adapter.notifyDataSetChanged()
		}

		viewModel.onError = {
			Log.e("Kotlin Everywhere", "ViewModel emitted an error!")
			it.printStackTrace()
		}

		this.setupToolbar()
	}
}
