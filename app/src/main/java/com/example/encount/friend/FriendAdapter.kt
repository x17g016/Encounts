package com.example.encount.friend

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.encount.user.UserFriendList
import com.example.encount.user.UserLikeList
import com.example.encount.user.UserPostList

//import kotlinx.android.synthetic.main.post_list.view.*
//import kotlinx.android.synthetic.main.post_list.view.UserIcon
//import kotlinx.android.synthetic.main.post_list.view.UserId

/**
 * やってること
 * カスタムListViewを適用するためのクラス
 *
 * 製作者：中村
 */

/*
class FriendAdapter(val context: Context, val posts: List<PostList>): BaseAdapter() {

    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return posts.count()
    }

    override fun getItem(position: Int): PostList {
        return posts[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = layoutInflater.inflate(R.layout.friend_list, parent, false)
        view.FriendName.text   = posts[position].name
        view.UserId.text       = posts[position].userid
        Glide.with(context).load(posts[position].image).into(view.UserIcon)

        return view
    }
}*/
class TabAdapter(fm: FragmentManager, private val context: Context): FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getItem(i: Int): Fragment {

        when (i) {
            0 -> return UserPostList()
            1 -> return UserFriendList()
            else -> return UserLikeList()
        }

    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "投稿"
            1 -> return "フレンド"
            else -> return "いいね"
        }
    }

}
