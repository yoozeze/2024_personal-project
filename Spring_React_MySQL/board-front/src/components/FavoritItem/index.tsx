import React from 'react';
import './style.css';
import { FavoriteListItem } from 'types/interface';
import defaultProfileImage from 'assets/image/01_모코코콘1_16_백색모코코_물음표.png';

interface Props {
    favoriteListItem: FavoriteListItem
}
//          component: Favorit List Item 컴포넌트
export default function FavoriteItem({ favoriteListItem }: Props) {

    //          properties
    const {profileImage, nickname} = favoriteListItem;

    //          render: Favorit List Item 컴포넌트 렌더링
    return (
        <div className='favorite-list-item'>
            <div className="favorite-list-item-profile-box">
                <div className="favorite-list-item-profile-image" style={{ backgroundImage: `url(${profileImage ? profileImage : defaultProfileImage})` }}></div>
            </div>
            <div className="favorite-list-item-nickname">{nickname}</div>
        </div>
    )
}
