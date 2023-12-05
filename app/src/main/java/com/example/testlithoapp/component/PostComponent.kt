package com.example.testlithoapp.component

import android.graphics.Typeface
import android.widget.ImageView
import com.example.testlithoapp.R
import com.example.testlithoapp.model.Post
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentScope
import com.facebook.litho.KComponent
import com.facebook.litho.Row
import com.facebook.litho.Style
import com.facebook.litho.core.height
import com.facebook.litho.core.margin
import com.facebook.litho.core.padding
import com.facebook.litho.core.width
import com.facebook.litho.flexbox.aspectRatio
import com.facebook.litho.kotlin.widget.Image
import com.facebook.litho.kotlin.widget.Text
import com.facebook.litho.useState
import com.facebook.litho.view.onClick
import com.facebook.rendercore.dp
import com.facebook.rendercore.drawableRes
import com.facebook.yoga.YogaAlign

class PostComponent(val post: Post) : KComponent() {

    override fun ComponentScope.render(): Component {
        return Column {
            val isLiked = useState { false }
            child(
                Row(alignItems = YogaAlign.CENTER, style = Style.padding(all = 8.dp)) {
                    child(
                        Image(
                            drawable = drawableRes(post.user.avatarRes),
                            style = Style.width(36.dp).height(36.dp)
                                .margin(start = 4.dp, end = 8.dp)
                        )
                    )
                    child(Text(text = post.user.username, textStyle = Typeface.BOLD))
                }
            )
            child(
                Image(
                    drawable = drawableRes(post.imageRes),
                    scaleType = ImageView.ScaleType.CENTER_CROP,
                    style = Style.aspectRatio(1f)
                )
            )
            Image(
                drawable =
                drawableRes(
                    if (isLiked.value) R.drawable.ic_baseline_favorite_24
                    else R.drawable.ic_baseline_favorite_border_24
                ),
                style =
                Style.width(32.dp).height(32.dp).margin(all = 6.dp).onClick {
                    isLiked.update { isLiked -> !isLiked }
                })
        }
    }
}