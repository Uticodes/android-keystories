
package com.project.android_kidstories.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity
public class Story implements Parcelable {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("category_id")
    @Expose
    private int categoryId;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("image_name")
    @Expose
    private String imageName;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("story_duration")
    @Expose
    private String storyDuration;
    @SerializedName("is_premium")
    @Expose
    private int isPremium;
    @SerializedName("likes_count")
    @Expose
    private int likesCount;
    @SerializedName("dislikes_count")
    @Expose
    private int dislikesCount;
    @SerializedName("reaction")
    @Expose
    private String reaction;
    @SerializedName("bookmark")
    @Expose
    private boolean bookmark;
    @SerializedName("comments")
    @Expose
    @Ignore
    private Comments comments;

    //****** Ehma Added Field ******//

    private boolean liked;
    private boolean disliked;

    protected Story(Parcel in) {
        id = in.readInt();
        title = in.readString();
        body = in.readString();
        categoryId = in.readInt();
        userId = in.readInt();
        imageUrl = in.readString();
        imageName = in.readString();
        age = in.readString();
        author = in.readString();
        storyDuration = in.readString();
        isPremium = in.readInt();
        likesCount = in.readInt();
        dislikesCount = in.readInt();
        reaction = in.readString();
        bookmark = in.readByte() != 0;
        liked = in.readByte() != 0;
        disliked = in.readByte() != 0;
    }

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };
    public Story() {
        //Please do not delete
    }
    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isDisliked() {
        return disliked;
    }

    public void setDisliked(boolean disliked) {
        this.disliked = disliked;
    }

    //****** ***********   ******//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStoryDuration() {
        return storyDuration;
    }

    public void setStoryDuration(String storyDuration) {
        this.storyDuration = storyDuration;
    }

    public int getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(int isPremium) {
        this.isPremium = isPremium;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getDislikesCount() {
        return dislikesCount;
    }

    public void setDislikesCount(int dislikesCount) {
        this.dislikesCount = dislikesCount;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public boolean isBookmark() {
        return bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }

    @Ignore
    public Comments getComments() {
        return comments;
    }

    @Ignore
    public void setComments(Comments comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Story)) return false;
        Story story = (Story) o;
        return getId() == story.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(body);
        parcel.writeInt(categoryId);
        parcel.writeInt(userId);
        parcel.writeString(imageUrl);
        parcel.writeString(imageName);
        parcel.writeString(age);
        parcel.writeString(author);
        parcel.writeString(storyDuration);
        parcel.writeInt(isPremium);
        parcel.writeInt(likesCount);
        parcel.writeInt(dislikesCount);
        parcel.writeString(reaction);
        parcel.writeByte((byte) (bookmark ? 1 : 0));
        parcel.writeByte((byte) (liked ? 1 : 0));
        parcel.writeByte((byte) (disliked ? 1 : 0));
    }
}
