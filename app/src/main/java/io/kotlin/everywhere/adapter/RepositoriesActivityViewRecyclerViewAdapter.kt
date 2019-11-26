/**
 * Created by [Author].
 */

package io.kotlin.everywhere.adapter

import io.kotlin.everywhere.R
import android.view.View
import android.support.constraint.ConstraintLayout
import android.widget.ImageView
import java.util.*
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import io.kotlin.everywhere.model.GitHubRepo


class RepositoriesActivityViewRecyclerViewAdapter(
		var items: List<GitHubRepo>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

		return ViewViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_view_holder, parent, false))
	}
	
	override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
	
		// Here you can bind RecyclerView item data.
		(viewHolder as ViewViewHolder).bind(this.items[position])
	}
	
	override fun getItemCount(): Int {
	
		return this.items.size
	}
	
	
	class ViewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
	
		private lateinit var repoLinkTextView: TextView
		private lateinit var aCimplementationOtextView: TextView
		private lateinit var authorTextView: TextView
		private lateinit var repoNameTextView: TextView
		init {
			init()
		}
		
		fun init() {
		
			// Configure Repo Link component
			repoLinkTextView = this.itemView.findViewById(R.id.repo_link_text_view)
			
			// Configure A C implementation o component
			aCimplementationOtextView = this.itemView.findViewById(R.id.a_cimplementation_otext_view)
			
			// Configure Author component
			authorTextView = this.itemView.findViewById(R.id.author_text_view)
			
			// Configure Repo Name component
			repoNameTextView = this.itemView.findViewById(R.id.repo_name_text_view)
		}


		fun bind(repo: GitHubRepo) {
			this.repoLinkTextView.text = repo.url
			this.aCimplementationOtextView.text = if (repo.userDescription.isNullOrBlank()) "No description provided" else repo.userDescription!!
			this.authorTextView.text = "Owner: ${repo.owner.name}"
			this.repoNameTextView.text = repo.name
		}
	}
}
