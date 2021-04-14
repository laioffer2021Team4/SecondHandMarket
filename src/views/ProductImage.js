import React, {Component} from 'react';
import ImageGallery from 'react-image-gallery';

const images = [
  {
    original: 'https://picsum.photos/id/1018/1000/600/',
    thumbnail: 'https://picsum.photos/id/1018/250/150/',
  },
  {
    original: 'https://picsum.photos/id/1015/1000/600/',
    thumbnail: 'https://picsum.photos/id/1015/250/150/',
  },
  {
    original: 'https://picsum.photos/id/1019/1000/600/',
    thumbnail: 'https://picsum.photos/id/1019/250/150/',
  },
];

class ProductImage extends Component {

  state = {
    images: []
  }

  // get image info from props
  componentDidMount() {
    // determine whether the images exist
    // props.xxx.images && props.xxx.images.length > 0
    // create images[]
    // for each image, push its {original, thumbnail} into images[]
  }

  render() {
    return (
      <div >
        <ImageGallery items={images} />;
      </div>
    );
  }
}

export default ProductImage;
